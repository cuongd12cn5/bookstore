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

public class UserJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int checkLogin(KhachHang kh) {
		String SQL = "select * from tblkhachhang where tenDangNhap = ? and matKhau = ?";
		List<KhachHang> result = jdbcTemplateObject.query(SQL, new Object[] {
				kh.getTenDangNhap(), kh.getMatKhau() }, new KhachHangMapper());
		if (result.size() > 0) {
			return 0;// để biết là khách hàng
		} else {
			SQL = "select * from tblnhanvien where tenDangNhap = ? and matKhau = ?";
			List<NhanVien> result1 = jdbcTemplateObject.query(SQL,
					new Object[] { kh.getTenDangNhap(), kh.getMatKhau() },
					new NhanVienMapper());
			if (result1.size() > 0) {
				return 1; // để biết là nhân viên
			} else {
				return -1;// không có tài khoản
			}
		}
	}

	private int maxIdKH() {
		int max = 0;
		String sql = "SELECT MAX(maKH) FROM tblkhachhang";
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
	
	public int getQuyen(String username) {
		int quyen = 0;
		String sql = "SELECT quyen from tblnhanvien where tenDangNhap=?";
		ArrayList<Integer> ltquyen = (ArrayList<Integer>) jdbcTemplateObject
				.query(sql, new Object[] { username },
						new RowMapper<Integer>() {

							@Override
							public Integer mapRow(ResultSet rs, int arg1)
									throws SQLException {
								// TODO Auto-generated method stub
								return rs.getInt(1);
							}

						});
		quyen = ltquyen.get(0);
		return quyen;
	}

	public boolean addKH(KhachHang kh) {
		String SQL = "select * from tblnhanvien where tenDangNhap = ?";
		List<NhanVien> result = jdbcTemplateObject.query(SQL,
				new Object[] { kh.getTenDangNhap() }, new NhanVienMapper());
		if (result.size() > 0) {
			return false;
		} else {
			SQL = "select * from tblkhachhang where tenDangNhap = ?";
			List<KhachHang> result1 = jdbcTemplateObject
					.query(SQL, new Object[] { kh.getTenDangNhap() },
							new KhachHangMapper());
			if (result1.size() > 0) {
				return false;
			}
		}
		kh.setMaKH(maxIdKH() + 1);
		SQL = "insert into tblkhachhang (maKH,tenKH,diaChi,lienHe,tenDangNhap,matKhau) values (?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL, kh.getMaKH(), kh.getTenKH(),
				kh.getDiaChi(), kh.getLienHe(), kh.getTenDangNhap(),
				kh.getMatKhau());
		return true;
	}

	public KhachHang getKHByUsername(String username) {
		String sql = "select * from tblkhachhang where tenDangNhap=?";
		List<KhachHang> result = jdbcTemplateObject.query(sql,
				new Object[] { username }, new KhachHangMapper());
		KhachHang kh = result.get(0);
		return kh;
	}

	private int maxidDatSach() {
		int max = 0;
		String sql = "SELECT MAX(maDatSach) FROM tbldatsach";
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

	public void addDatSach(DatSach datSach) {
		datSach.setMaDatSach(maxidDatSach() + 1);
		String SQL = "insert into tbldatsach (maDatSach,maKH, maSach, soLuong,tongTien,ngayDat,isCheck) values (?,?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL, datSach.getMaDatSach(), datSach.getKh()
				.getMaKH(), datSach.getSach().getMaSach(),
				datSach.getSoLuong(), datSach.getTongTien(), datSach
						.getNgayDat(), datSach.isCheck());
	}
}
