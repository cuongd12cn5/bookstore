package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DanhMucSach;
import model.Sach;

import org.springframework.jdbc.core.RowMapper;

public class SachMapper implements RowMapper<Sach> {
	@Override
	public Sach mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Sach sach=new Sach();
		sach.setMaSach(rs.getInt("maSach"));
		sach.setTenSach(rs.getString("tenSach"));
		sach.setTacGia(rs.getString("tacGia"));
		sach.setNhaXuatBan(rs.getString("nhaXuatBan"));
		sach.setNamXuatBan(rs.getInt("namXuatBan"));
		sach.setImage(rs.getString("image"));
		sach.setGia(rs.getLong("gia"));
		sach.setMoTa(rs.getString("moTa"));
		DanhMucSach danhMuc=new DanhMucSach();
		danhMuc.setMaDanhMuc(rs.getInt("maDanhMuc"));
		danhMuc.setTenDanhMuc(rs.getString("tenDanhMuc"));
		danhMuc.setMoTa(rs.getString("moTa"));
		sach.setDanhMuc(danhMuc);
		return sach;
	}
}
