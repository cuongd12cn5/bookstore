package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.DanhMucSach;
import model.DatSach;
import model.KhachHang;
import model.Sach;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controller.UserJDBCTemplate;

@Controller
@RequestMapping("/frame")
public class FrameController {

	private ApplicationContext context = null;
	private UserJDBCTemplate userJDBCTemplate = null;
	private SachJDBCTemplate sachJDBCTemplate = null;

	public FrameController() {
		context = new ClassPathXmlApplicationContext("Beans.xml");
		userJDBCTemplate = (UserJDBCTemplate) context
				.getBean("userJDBCTemplate");
		sachJDBCTemplate = (SachJDBCTemplate) context
				.getBean("sachJDBCTemplate");
	}

	@RequestMapping(value = "/homepage", method = RequestMethod.GET)
	public ModelAndView homePage(ModelMap model, HttpSession session) {
		ArrayList<DanhMucSach> listDanhMuc = sachJDBCTemplate.getDanhMucSach();
		session.setAttribute("listDanhMuc", listDanhMuc);
		model.addAttribute("listSach", sachJDBCTemplate.getSach());
		return new ModelAndView("Homepage", "command", new Sach());
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView userLogin() {
		return new ModelAndView("DangNhap", "command", new KhachHang());
	}

	@RequestMapping(value = "/loginCheck", method = RequestMethod.POST)
	public ModelAndView checkUser(
			@ModelAttribute("SpringWebDemo") KhachHang kh, ModelMap model,
			HttpSession session) {
		int check = userJDBCTemplate.checkLogin(kh);
		if (check == 0) {
			session.setAttribute("user", kh.getTenDangNhap());
			session.setAttribute("rules", "0");
		} else {
			if (check == 1) {
				session.setAttribute("user", kh.getTenDangNhap());
				session.setAttribute("rules", "1");
			} else {
				model.addAttribute("thongbao", "Đăng nhập thất bại");
				return new ModelAndView("DangNhap", "command", new KhachHang());
			}
		}
		model.addAttribute("listSach", sachJDBCTemplate.getSach());
		return new ModelAndView("Homepage", "command", new Sach());
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView userRegister() {
		return new ModelAndView("DangKy", "command", new KhachHang());
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("SpringWeb") KhachHang kh,
			ModelMap model) {
		if (kh.getTenDangNhap().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập tên đăng nhập");
			return new ModelAndView("DangKy", "command", new KhachHang());
		}
		if (kh.getMatKhau().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập mật khẩu");
			return new ModelAndView("DangKy", "command", new KhachHang());
		}
		if (kh.getTenKH().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập họ tên");
			return new ModelAndView("DangKy", "command", new KhachHang());
		}
		if (kh.getLienHe().equals("")) {
			model.addAttribute("thongbao",
					"Bạn chưa nhập số điện thoại liên hệ");
			return new ModelAndView("DangKy", "command", new KhachHang());
		}
		if (kh.getDiaChi().equals("")) {
			model.addAttribute("thongbao", "Bạn chưa nhập địa chi");
			return new ModelAndView("DangKy", "command", new KhachHang());
		}
		if (userJDBCTemplate.addKH(kh)) {
			model.addAttribute("thongbao",
					"Đăng ký thành công, Bạn có thể đăng nhập");
			return new ModelAndView("DangNhap", "command", new KhachHang());
		} else {
			model.addAttribute("thongbao", "Tài khoản đã tồn tại");
			return new ModelAndView("DangKy", "command", new KhachHang());
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		if (session.getAttribute("user") != null)
			session.removeAttribute("user");
		return "redirect:/";
	}

	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
	public ModelAndView userProfile(ModelMap model, HttpSession session) {
		String username = (String) session.getAttribute("user");
		String rules = (String) session.getAttribute("rules");
		if (rules.equals("0")) {
			KhachHang kh = userJDBCTemplate.getKHByUsername(username);
			model.addAttribute("kh", kh);
			return new ModelAndView("KhachHang/Edit", "command",
					new KhachHang());
		} else {
			int quyen = userJDBCTemplate.getQuyen(username);
			if (quyen == 1) {
				return new ModelAndView("QuanLy/QuanLyPage");
			} else {
				return new ModelAndView("BanHang/BanHangPage");
			}
		}
	}

	@RequestMapping(value = "/typeSach", method = RequestMethod.GET)
	public ModelAndView typeProduct(ModelMap model, HttpServletRequest request,
			HttpSession session) {
		String type = request.getParameter("type");
		session.setAttribute("type", type);
		model.addAttribute("listSach",
				sachJDBCTemplate.listSachByDanhMuc(Integer.parseInt(type)));
		return new ModelAndView("SachPage", "command", new Sach());
	}

	@RequestMapping(value = "/ViewSach", method = RequestMethod.GET)
	public ModelAndView addSach(ModelMap model, HttpSession session,
			HttpServletRequest request) {
		String id = request.getParameter("id");
		Sach sach=sachJDBCTemplate.getSachByID(Integer.parseInt(id));
		model.addAttribute("sach", sach);
		return new ModelAndView("DatSach", "command", new DatSach());
	}

	@RequestMapping(value = "/DatSach", method = RequestMethod.POST)
	public ModelAndView booking(@ModelAttribute("SpringWeb")DatSach datSach,ModelMap model, HttpSession session,
			HttpServletRequest request) {
		String maSach=request.getParameter("maSach");
		Sach sach=sachJDBCTemplate.getSachByID(Integer.parseInt(maSach));
		String username = (String) session.getAttribute("user");
		
		if (username == null||username.isEmpty()) {
			model.addAttribute("thongbao", "Bạn chưa đăng nhập");
			model.addAttribute("sach", sach);
			return new ModelAndView("DatSach", "command", new DatSach());
		}
		String rules = (String) session.getAttribute("rules");
		if(rules.equals("1")){
			model.addAttribute("thongbao", "Tài khoản của bạn không được đặt sách");
			model.addAttribute("sach", sach);
			return new ModelAndView("DatSach", "command", new DatSach());
		}
		datSach.setSach(sach);
		KhachHang kh=userJDBCTemplate.getKHByUsername(username);
		datSach.setKh(kh);
		long tongTien=sach.getGia()*datSach.getSoLuong();
		datSach.setTongTien(tongTien);
		datSach.setCheck(0);
		Date today = new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat = new SimpleDateFormat(
				"HH:mm:ss dd/MM/yyyy");
		String date = timeFormat.format(today.getTime());
		datSach.setNgayDat(date);
		userJDBCTemplate.addDatSach(datSach);
		model.addAttribute("sach", sach);
		model.addAttribute("thongbaoDatSach", "Đặt sách thành công");
		return new ModelAndView("DatSach", "command", new DatSach());
	}

	@RequestMapping(value = "/searhSach", method = RequestMethod.POST)
	public ModelAndView searhProduct(@ModelAttribute("SpringWeb") Sach sach,
			ModelMap model) {
		model.addAttribute("listSach", sachJDBCTemplate.getSachbyName(sach.getTenSach()));
		return new ModelAndView("SachSearch", "command", new Sach());
	}
}
