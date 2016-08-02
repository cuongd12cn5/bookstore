package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.KhachHang;

import org.springframework.jdbc.core.RowMapper;

public class KhachHangMapper  implements RowMapper<KhachHang>{
@Override
public KhachHang mapRow(ResultSet rs, int arg1) throws SQLException {
	// TODO Auto-generated method stub
	KhachHang kh=new KhachHang();
	kh.setMaKH(rs.getInt("maKH"));
	kh.setTenKH(rs.getString("tenKH"));
	kh.setDiaChi(rs.getString("diaChi"));
	kh.setLienHe(rs.getString("lienHe"));
	kh.setTenDangNhap(rs.getString("tenDangNhap"));
	kh.setMatKhau(rs.getString("matKhau"));
	return kh;
}
}
