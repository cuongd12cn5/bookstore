package controller;


import javax.servlet.http.HttpSession;

import model.KhachHang;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private ApplicationContext context = null;
	private CustomerJDBCTemplate customerJDBCTemplate=null;
	
	public CustomerController() {
		// TODO Auto-generated constructor stub
		context = new ClassPathXmlApplicationContext("Beans.xml");
		customerJDBCTemplate=(CustomerJDBCTemplate) context.getBean("customerJDBCTemplate");
	}
	
	@RequestMapping(value = "/Edit", method = RequestMethod.POST)
	public ModelAndView EditPass(@ModelAttribute("SpringWeb") KhachHang kh, ModelMap model, HttpSession session) {
		String username=(String) session.getAttribute("user");
		kh.setTenDangNhap(username);
		if (kh.getMatKhau().equals("")) {
			model.addAttribute("kh", kh);
			model.addAttribute("thongbao", "Bạn chưa nhập mật khẩu");
			return new ModelAndView("KhachHang/Edit", "command", new KhachHang());
		}
		if (kh.getTenKH().equals("")) {
			model.addAttribute("kh", kh);
			model.addAttribute("thongbao", "Bạn chưa nhập họ tên");
			return new ModelAndView("KhachHang/Edit", "command", new KhachHang());
		}
		if (kh.getLienHe().equals("")) {
			model.addAttribute("kh", kh);
			model.addAttribute("thongbao",
					"Bạn chưa nhập số điện thoại liên hệ");
			return new ModelAndView("KhachHang/Edit", "command", new KhachHang());
		}
		if (kh.getDiaChi().equals("")) {
			model.addAttribute("kh", kh);
			model.addAttribute("thongbao", "Bạn chưa nhập địa chi");
			return new ModelAndView("KhachHang/Edit", "command", new KhachHang());
		}
		customerJDBCTemplate.updateCustomer(kh);
		model.addAttribute("thongbao", "Cập nhật thành công");
		model.addAttribute("kh", kh);
		return new ModelAndView("KhachHang/Edit","command",new KhachHang());
	}
}
