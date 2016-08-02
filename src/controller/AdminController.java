package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.KhachHang;
import model.NhanVien;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {
	private ApplicationContext context = null;
	private AdminJDBCTemplate adminJDBCTemplate = null;

	public AdminController() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		adminJDBCTemplate = (AdminJDBCTemplate) context
				.getBean("adminJDBCTemplate");
	}

	@RequestMapping(value = "/QLNV", method = RequestMethod.GET)
	public ModelAndView quanLyNV() {
		return new ModelAndView("QuanLy/QLNhanVien");
	}

	@RequestMapping(value = "/ThemNV", method = RequestMethod.GET)
	public ModelAndView themNV() {
		return new ModelAndView("QuanLy/ThemNV", "command", new NhanVien());
	}

	@RequestMapping(value = "/themNV", method = RequestMethod.POST)
	public ModelAndView themNV1(@ModelAttribute("SpringWeb") NhanVien nv,
			ModelMap model) {
		if (nv.getTenDangNhap().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập tên đăng nhập");
			return new ModelAndView("QuanLy/ThemNV", "command", new NhanVien());
		}
		if (nv.getMatKhau().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập mật khẩu");
			return new ModelAndView("QuanLy/ThemNV", "command", new NhanVien());
		}
		if (nv.getTenNV().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập họ tên");
			return new ModelAndView("QuanLy/ThemNV", "command", new NhanVien());
		}
		if (nv.getLienHe().equals("")) {
			model.addAttribute("thongbao",
					"Bạn chưa nhập số điện thoại liên hệ");
			return new ModelAndView("QuanLy/ThemNV", "command", new NhanVien());
		}
		if (nv.getDiaChi().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập địa chi");
			return new ModelAndView("QuanLy/ThemNV", "command", new NhanVien());
		}
		if (nv.getQuyen() == 1) {
			nv.setViTri("Quản lý");
		} else {
			nv.setViTri("Bán hàng");
		}
		if (adminJDBCTemplate.addNV(nv)) {
			model.addAttribute("thongbaothem", "Thêm nhân viên thành công");
			return new ModelAndView("QuanLy/QLNhanVien");
		} else {
			model.addAttribute("thongbao", "Tài khoản đã tồn tại");
			return new ModelAndView("QuanLy/ThemNV", "command", new NhanVien());
		}

	}

	@RequestMapping(value = "/TimKiemNV", method = RequestMethod.GET)
	public ModelAndView TimKiemNV(ModelMap model) {
		model.addAttribute("listnv", adminJDBCTemplate.getNV());
		return new ModelAndView("QuanLy/TimKiemNV", "command", new NhanVien());
	}

	@RequestMapping(value = "/timkiemNV", method = RequestMethod.POST)
	public ModelAndView TimKiemNV1(@ModelAttribute("SpringWeb") NhanVien nv,
			ModelMap model) {
		model.addAttribute("listnv", adminJDBCTemplate.getNVbyName(nv.getTenNV()));
		return new ModelAndView("QuanLy/TimKiemNV", "command", new NhanVien());
	}

	@RequestMapping(value = "/xoaNV", method = RequestMethod.GET)
	public ModelAndView xoaNV(HttpServletRequest request, ModelMap model) {
		adminJDBCTemplate
				.deleteNV(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("thongbaoxoa", "Xóa thành công");
		model.addAttribute("listnv", adminJDBCTemplate.getNV());
		return new ModelAndView("QuanLy/TimKiemNV", "command", new NhanVien());
	}

	@RequestMapping(value = "/QLKH", method = RequestMethod.GET)
	public ModelAndView quanLyKH(ModelMap model) {
		model.addAttribute("listkh", adminJDBCTemplate.getKH());
		return new ModelAndView("QuanLy/TimKiemKH", "command", new KhachHang());
	}

	@RequestMapping(value = "/timkiemKH", method = RequestMethod.POST)
	public ModelAndView TimKiemKH1(@ModelAttribute("SpringWeb") KhachHang kh,
			ModelMap model) {
		model.addAttribute("listkh", adminJDBCTemplate.getKHbyName(kh.getTenKH()));
		return new ModelAndView("QuanLy/TimKiemKH", "command", new KhachHang());
	}

	@RequestMapping(value = "/xoaKH", method = RequestMethod.GET)
	public ModelAndView xoaKH(HttpServletRequest request, ModelMap model) {
		adminJDBCTemplate
				.deleteKH(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("thongbaoxoa", "Xóa thành công");
		model.addAttribute("listkh", adminJDBCTemplate.getKH());
		return new ModelAndView("QuanLy/TimKiemKH", "command", new KhachHang());
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView editpass(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("user");
		NhanVien nv = adminJDBCTemplate.getNVByUsername(username);
		model.addAttribute("nv", nv);
		return new ModelAndView("QuanLy/Edit", "command", new NhanVien());
	}

	@RequestMapping(value = "/Edit", method = RequestMethod.POST)
	public ModelAndView EditPass(@ModelAttribute("SpringWeb") NhanVien nv,
			ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("user");
		nv.setTenDangNhap(username);
		if (nv.getMatKhau().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao", "Bạn chưa nhập mật khẩu");
			return new ModelAndView("QuanLy/Edit", "command", new NhanVien());
		}
		if (nv.getTenNV().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao", "Bạn chưa nhập họ tên");
			return new ModelAndView("QuanLy/Edit", "command", new NhanVien());
		}
		if (nv.getLienHe().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao",
					"Bạn chưa nhập số điện thoại liên hệ");
			return new ModelAndView("QuanLy/Edit", "command", new NhanVien());
		}
		if (nv.getDiaChi().equals("")) {
			model.addAttribute("nv", nv);
			model.addAttribute("thongbao", "Bạn chưa nhập địa chi");
			return new ModelAndView("QuanLy/Edit", "command", new NhanVien());
		}
		adminJDBCTemplate.updateNV(nv);
		model.addAttribute("thongbaoedit", "Cập nhật thành công");
		return new ModelAndView("QuanLy/QuanLyPage");
	}
}
