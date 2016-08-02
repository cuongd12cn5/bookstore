package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.NhanVien;

import org.springframework.jdbc.core.RowMapper;

public class NhanVienMapper implements RowMapper<NhanVien> {
@Override
public NhanVien mapRow(ResultSet rs, int arg1) throws SQLException {
	// TODO Auto-generated method stub
	NhanVien nv=new NhanVien();
	nv.setMaNV(rs.getInt("maNV"));
	nv.setTenNV(rs.getString("tenNV"));
	nv.setDiaChi(rs.getString("diaChi"));
	nv.setLienHe(rs.getString("lienHe"));
	nv.setTenDangNhap(rs.getString("tenDangNhap"));
	nv.setMatKhau(rs.getString("matKhau"));
	nv.setViTri(rs.getString("viTri"));
	nv.setQuyen(rs.getInt("quyen"));
	return nv;
}
}
