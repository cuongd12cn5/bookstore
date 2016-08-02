package controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.DatSach;
import model.KhachHang;
import model.Sach;

import org.springframework.jdbc.core.RowMapper;

public class DatSachMapper implements RowMapper<DatSach>{

	@Override
	public DatSach mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		KhachHang kh=new KhachHang();
		kh.setMaKH(rs.getInt("maKH"));
		kh.setTenKH(rs.getString("tenKH"));
		kh.setDiaChi(rs.getString("diaChi"));
		Sach sach=new Sach();
		sach.setMaSach(rs.getInt("maSach"));
		sach.setTenSach(rs.getString("tenSach"));
		DatSach datSach=new DatSach();
		datSach.setMaDatSach(rs.getInt("maDatSach"));
		datSach.setKh(kh);
		datSach.setSach(sach);
		datSach.setSoLuong(rs.getInt("soLuong"));
		datSach.setTongTien(rs.getLong("tongTien"));
		datSach.setNgayDat(rs.getString("ngayDat"));
		datSach.setCheck(rs.getInt("isCheck"));
		return datSach;
	}

}
