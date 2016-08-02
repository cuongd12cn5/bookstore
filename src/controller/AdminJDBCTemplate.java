package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import model.DatSach;
import model.KhachHang;
import model.NhanVien;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class AdminJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public ArrayList<NhanVien> getNVbyName(String tenNV) {
		String sql = "SELECT * FROM tblnhanvien WHERE tenNV LIKE'%"
				+ tenNV + "%';";
		ArrayList<NhanVien> result = (ArrayList<NhanVien>) jdbcTemplateObject
				.query(sql, new NhanVienMapper());
		return result;
	}

	public ArrayList<KhachHang> getKHbyName(String tenKH) {
		String sql = "SELECT * FROM tblkhachhang WHERE tenKH LIKE'%"
				+ tenKH + "%';";
		ArrayList<KhachHang> result = (ArrayList<KhachHang>) jdbcTemplateObject
				.query(sql, new KhachHangMapper());
		return result;
	}

	public void deleteNV(int id) {
		String sql1="UPDATE tbldatsach set maNV=null where maNV=?";
		jdbcTemplateObject.update(sql1, new Object[] { id });
		String sql = "DELETE from tblnhanvien where maNV=?";
		jdbcTemplateObject.update(sql, new Object[] { id });
	}

	public void deleteKH(int id) {
		String sql1 = "DELETE from tbldatsach where maKH=?";
		jdbcTemplateObject.update(sql1, new Object[] { id });
		String sql = "DELETE from tblkhachhang where maKH=?";
		jdbcTemplateObject.update(sql, new Object[] { id });
	}

	public ArrayList<NhanVien> getNV() {
		String sql = "SELECT * FROM tblnhanvien";
		ArrayList<NhanVien> result = (ArrayList<NhanVien>) jdbcTemplateObject
				.query(sql, new NhanVienMapper());
		return result;
	}

	public ArrayList<KhachHang> getKH() {
		String sql = "SELECT * FROM tblkhachhang";
		ArrayList<KhachHang> result = (ArrayList<KhachHang>) jdbcTemplateObject
				.query(sql, new KhachHangMapper());
		return result;
	}

	public ArrayList<DatSach> getDatSach() {
		String sql = "SELECT * from tblsach,tbldatsach,tblkhachhang where "
				+ " tblsach.maSach=tbldatsach.maSach and "
				+ " tbldatsach.maKH=tblkhachhang.maKH and" + " isCheck=0";
		ArrayList<DatSach> result = (ArrayList<DatSach>) jdbcTemplateObject
				.query(sql, new DatSachMapper());
		return result;
	}

	public void updateDonHang(int maDon, int maNV) {
		String sql = "update tbldatsach set isCheck=1 ,maNV=? where maDatSach=?";
		jdbcTemplateObject.update(sql, new Object[] { maNV, maDon });
	}

	private int maxIdNV() {
		int max = 0;
		String sql = "SELECT MAX(maNV) FROM tblnhanvien";
		ArrayList<Integer> id = (ArrayList<Integer>) jdbcTemplateObject.query(
				sql, new RowMapper<Integer>() {
					@Override
					public Integer mapRow(ResultSet rs, int row)
							throws SQLException {
						// TODO Auto-generated method stub
						return rs.getInt(1);
					}
				});
		max = id.get(0);
		return max;
	}

	public boolean addNV(NhanVien nv) {
		String SQL = "select * from tblnhanvien where tenDangNhap = ?";
		List<NhanVien> result = jdbcTemplateObject.query(SQL,
				new Object[] { nv.getTenDangNhap() }, new NhanVienMapper());
		if (result.size() > 0) {
			return false;
		} else {
			SQL = "select * from tblkhachhang where tenDangNhap = ?";
			List<KhachHang> result1 = jdbcTemplateObject
					.query(SQL, new Object[] { nv.getTenDangNhap() },
							new KhachHangMapper());
			if (result1.size() > 0) {
				return false;
			}
		}
		nv.setMaNV(maxIdNV() + 1);
		SQL = "insert into tblnhanvien (maNV,tenNV,diaChi,lienHe,tenDangNhap,matKhau,viTri,quyen) values (?,?,?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL, nv.getMaNV(), nv.getTenNV(),
				nv.getDiaChi(), nv.getLienHe(), nv.getTenDangNhap(),
				nv.getMatKhau(), nv.getViTri(), nv.getQuyen());
		return true;
	}

	public void updateNV(NhanVien nv) {
		String sql = "UPDATE tblnhanvien set matKhau=?,tenNV=?,diaChi=?,lienHe=? where tenDangNhap=?";
		jdbcTemplateObject.update(sql,
				new Object[] { nv.getMatKhau(), nv.getTenNV(), nv.getDiaChi(),
						nv.getLienHe(), nv.getTenDangNhap() });
	}

	public NhanVien getNVByUsername(String username) {
		String sql = "select * from tblnhanvien where tenDangNhap=?";
		List<NhanVien> result = jdbcTemplateObject.query(sql,
				new Object[] { username }, new NhanVienMapper());
		NhanVien nv = result.get(0);
		return nv;
	}
}
