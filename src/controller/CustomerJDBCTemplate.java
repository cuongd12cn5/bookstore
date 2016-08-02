package controller;
import javax.sql.DataSource;

import model.KhachHang;

import org.springframework.jdbc.core.JdbcTemplate;

public class CustomerJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void updateCustomer(KhachHang kh) {
		String sql = "UPDATE tblkhachhang set matKhau=?,tenKH=?,diaChi=?,lienHe=? where tenDangNhap=?";
		jdbcTemplateObject.update(sql,
				new Object[] { kh.getMatKhau(), kh.getTenKH(), kh.getDiaChi(),
						kh.getLienHe(), kh.getTenDangNhap() });
	}
}
