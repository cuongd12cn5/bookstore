package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.NhanVien;
import model.Sach;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.jasper.tagplugins.jstl.core.Url;
import org.apache.tomcat.jni.Mmap;
import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/banhang")
public class BanHangController {
	private ApplicationContext context = null;
	private AdminJDBCTemplate adminJDBCTemplate = null;
	private SachJDBCTemplate sachJDBCTemplate = null;

	public BanHangController() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		adminJDBCTemplate = (AdminJDBCTemplate) context
				.getBean("adminJDBCTemplate");
		sachJDBCTemplate = (SachJDBCTemplate) context
				.getBean("sachJDBCTemplate");
	}

	@RequestMapping(value = "/QLSach", method = RequestMethod.GET)
	public ModelAndView managerProduct() {
		return new ModelAndView("BanHang/QLSach");
	}

	@RequestMapping(value = "/viewDonHang", method = RequestMethod.GET)
	public ModelAndView ViewDatSach(ModelMap model) {
		model.addAttribute("listDatSach", adminJDBCTemplate.getDatSach());
		return new ModelAndView("BanHang/CheckDonHang");
	}

	@RequestMapping(value = "/checkDonHang", method = RequestMethod.GET)
	public ModelAndView checkDatSach(HttpServletRequest request,
			ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("user");
		NhanVien nv = adminJDBCTemplate.getNVByUsername(username);
		adminJDBCTemplate.updateDonHang(
				Integer.parseInt(request.getParameter("maDon")), nv.getMaNV());
		model.addAttribute("listDatSach", adminJDBCTemplate.getDatSach());
		return new ModelAndView("BanHang/CheckDonHang");
	}

	@RequestMapping(value = "/edit1", method = RequestMethod.GET)
	public ModelAndView editpass1(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("user");
		NhanVien nv = adminJDBCTemplate.getNVByUsername(username);
		model.addAttribute("nv", nv);
		return new ModelAndView("BanHang/Edit", "command", new NhanVien());
	}

	@RequestMapping(value = "/Edit1", method = RequestMethod.POST)
	public ModelAndView EditPass1(@ModelAttribute("SpringWeb") NhanVien nv,
			ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("user");
		nv.setTenDangNhap(username);
		if (nv.getMatKhau().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao", "Bạn chưa nhập mật khẩu");
			return new ModelAndView("BanHang/Edit", "command", new NhanVien());
		}
		if (nv.getTenNV().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao", "Bạn chưa nhập họ tên");
			return new ModelAndView("BanHang/Edit", "command", new NhanVien());
		}
		if (nv.getLienHe().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao",
					"Bạn chưa nhập số điện thoại liên hệ");
			return new ModelAndView("BanHang/Edit", "command", new NhanVien());
		}
		if (nv.getDiaChi().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao", "Bạn chưa nhập địa chi");
			return new ModelAndView("BanHang/Edit", "command", new NhanVien());
		}
		adminJDBCTemplate.updateNV(nv);
		model.addAttribute("thongbaoedit", "Cập nhật thành công");
		return new ModelAndView("BanHang/BanHangPage");
	}

	@RequestMapping(value = "/viewSearchSach", method = RequestMethod.GET)
	public ModelAndView viewSearchProduct() {
		return new ModelAndView("BanHang/TraCuuSach", "command", new Sach());
	}

	@RequestMapping(value = "/searchSach", method = RequestMethod.POST)
	public ModelAndView searchProduct(@ModelAttribute("SpringWeb") Sach sach,
			ModelMap model) {
		model.addAttribute("listSach",
				sachJDBCTemplate.getSachbyName(sach.getTenSach()));
		return new ModelAndView("BanHang/TraCuuSach", "command", new Sach());
	}

	@RequestMapping(value = "/deleteSach", method = RequestMethod.GET)
	public ModelAndView deleteProduct(HttpServletRequest request, ModelMap model) {
		sachJDBCTemplate
				.deleteSach(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("thongbaoxoa", "Xóa thành công");
		model.addAttribute("listSach", sachJDBCTemplate.getSach());
		return new ModelAndView("BanHang/TraCuuSach", "command", new Sach());
	}

	@RequestMapping(value = "/viewEditSach", method = RequestMethod.GET)
	public ModelAndView viewEditProduct(HttpServletRequest request,
			ModelMap model) {
		Sach sach = sachJDBCTemplate.getSachByID(Integer.parseInt(request
				.getParameter("id")));
		model.addAttribute("sach", sach);
		return new ModelAndView("BanHang/SuaSach", "command", new Sach());
	}

	@RequestMapping(value = "/editSach", method = RequestMethod.POST)
	public ModelAndView editProduct(@ModelAttribute("SpringWeb") Sach sach,
			HttpServletRequest request, ModelMap model) {
		String maSach = request.getParameter("maSach");
		sach.setMaSach(Integer.parseInt(maSach));
		if (sach.getTenSach().equals("")) {
			model.addAttribute("sach", sach);
			model.addAttribute("thongbao", "Bạn chưa nhập tên sách");
			return new ModelAndView("BanHang/SuaSach", "command", new Sach());
		}
		if (sach.getTacGia().equals("")) {
			model.addAttribute("sach", sach);
			model.addAttribute("thongbao", "Bạn chưa nhập tên tác giả");
			return new ModelAndView("BanHang/SuaSach", "command", new Sach());
		}
		if (sach.getNhaXuatBan().equals("")) {
			model.addAttribute("sach", sach);
			model.addAttribute("thongbao", "Bạn chưa nhập nhà xuất bản");
			return new ModelAndView("BanHang/SuaSach", "command", new Sach());
		}
		if (sach.getNamXuatBan() == 0) {
			model.addAttribute("sach", sach);
			model.addAttribute("thongbao", "Bạn chưa nhập năm xuất bản");
			return new ModelAndView("BanHang/SuaSach", "command", new Sach());
		}
		if (sach.getGia() == 0) {
			model.addAttribute("sach", sach);
			model.addAttribute("thongbao", "Bạn chưa nhập giá sách");
			return new ModelAndView("BanHang/SuaSach", "command", new Sach());
		}
		if (sach.getMoTa().equals("")) {
			model.addAttribute("sach", sach);
			model.addAttribute("thongbao", "Bạn chưa nhập mô tả");
			return new ModelAndView("BanHang/SuaSach", "command", new Sach());
		}
		sachJDBCTemplate.updateSach(sach);
		model.addAttribute("thongbaosua", "Sửa thành công");
		return new ModelAndView("BanHang/QLSach");
	}

	@RequestMapping(value = "/viewAddSach", method = RequestMethod.GET)
	public ModelAndView viewAddSach(ModelMap model, HttpSession session) {
		model.addAttribute("danhmuc", session.getAttribute("listDanhMuc"));
		return new ModelAndView("BanHang/ThemSach", "command", new Sach());
	}

	@RequestMapping(value = "/addSach", method = RequestMethod.POST)
	public ModelAndView addSach(@ModelAttribute("SpringWeb") Sach sach,HttpServletRequest request,
			ModelMap model, HttpSession session,
			@RequestParam("file") MultipartFile file) {
		if (sach.getTenSach().equals("")) {
			model.addAttribute("danhmuc", session.getAttribute("listDanhMuc"));
			model.addAttribute("thongbao", "Bạn chưa nhập tên sách");
			return new ModelAndView("BanHang/ThemSach", "command", new Sach());
		}
		if (sach.getTacGia().equals("")) {
			model.addAttribute("danhmuc", session.getAttribute("listDanhMuc"));
			model.addAttribute("thongbao", "Bạn chưa nhập tên tác giả");
			return new ModelAndView("BanHang/ThemSach", "command", new Sach());
		}
		if (sach.getNhaXuatBan().equals("")) {
			model.addAttribute("danhmuc", session.getAttribute("listDanhMuc"));
			model.addAttribute("thongbao", "Bạn chưa nhập nhà xuất bản");
			return new ModelAndView("BanHang/ThemSach", "command", new Sach());
		}
		if (sach.getNamXuatBan() == 0) {
			model.addAttribute("danhmuc", session.getAttribute("listDanhMuc"));
			model.addAttribute("thongbao", "Bạn chưa nhập năm xuất bản");
			return new ModelAndView("BanHang/ThemSach", "command", new Sach());
		}
		if (sach.getGia() == 0) {
			model.addAttribute("danhmuc", session.getAttribute("listDanhMuc"));
			model.addAttribute("thongbao", "Bạn chưa nhập giá sách");
			return new ModelAndView("BanHang/ThemSach", "command", new Sach());
		}
		if (sach.getMoTa().equals("")) {
			model.addAttribute("danhmuc", session.getAttribute("listDanhMuc"));
			model.addAttribute("thongbao", "Bạn chưa nhập mô tả");
			return new ModelAndView("BanHang/ThemSach", "command", new Sach());
		}
		URL resource = getClass().getResource("/");
		String path = resource.getPath();
		String urlForder = path+"../../img/";
		String url=urlForder.replaceFirst("/", "");
		InputStream fis;
		OutputStream fos;
		try {
			fis = file.getInputStream();
			String fileName = file.getOriginalFilename(); // Ten ban dau
			model.MD5 md5 = new model.MD5();
			Date date=new Date();
			String ten = md5.encryptMD5(fileName+date);
			String tailFile = fileName.substring(fileName.indexOf("."),
					fileName.length());
			String filename = ten + tailFile;
			fos = new FileOutputStream(url + filename);
			int readBytes = 0;
			byte[] buffer = new byte[8192];
			while ((readBytes = fis.read(buffer, 0, 8192)) != -1) {
				fos.write(buffer, 0, readBytes);
			}
			fos.close();
			fis.close();
			sach.setImage(filename);
			sachJDBCTemplate.addSach(sach);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("thongbaothem", "Thêm thành công");
		return new ModelAndView("BanHang/QLSach");
	}
}
