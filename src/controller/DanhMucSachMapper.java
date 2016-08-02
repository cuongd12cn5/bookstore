package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DanhMucSach;

import org.springframework.jdbc.core.RowMapper;

public class DanhMucSachMapper implements RowMapper<DanhMucSach> {
	@Override
	public DanhMucSach mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		DanhMucSach danhMuc=new DanhMucSach();
		danhMuc.setMaDanhMuc(rs.getInt("maDanhMuc"));
		danhMuc.setTenDanhMuc(rs.getString("tenDanhMuc"));
		danhMuc.setMoTa(rs.getString("moTa"));
		return danhMuc;
	}
}
