package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import model.DanhMucSach;
import model.Sach;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class SachJDBCTemplate {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public ArrayList<DanhMucSach> getDanhMucSach() {
		String sql = "SELECT * from tbldanhmucsach";
		ArrayList<DanhMucSach> listDanhMuc = (ArrayList<DanhMucSach>) jdbcTemplateObject
				.query(sql, new DanhMucSachMapper());
		return listDanhMuc;
	}

	public ArrayList<Sach> getSach() {
		String sql = "SELECT * from tblsach,tbldanhmucsach where tblsach.maDanhMucSach=tbldanhmucsach.maDanhMuc";
		ArrayList<Sach> listSach = (ArrayList<Sach>) jdbcTemplateObject.query(
				sql, new SachMapper());
		return listSach;
	}

	public ArrayList<Sach> listSachByDanhMuc(int maDanhMuc) {
		String sql = "SELECT * FROM tblsach,tbldanhmucsach WHERE tblsach.maDanhMucSach=tbldanhmucsach.maDanhMuc and maDanhMuc=?";
		ArrayList<Sach> list = (ArrayList<Sach>) jdbcTemplateObject.query(sql,
				new Object[] { maDanhMuc }, new SachMapper());
		return list;
	}

	public Sach getSachByID(int id) {
		String sql = "SELECT * FROM tblsach,tbldanhmucsach where tblsach.maDanhMucSach=tbldanhmucsach.maDanhMuc and maSach=?";
		ArrayList<Sach> list = (ArrayList<Sach>) jdbcTemplateObject.query(sql,
				new Object[] { id }, new SachMapper());
		return list.get(0);
	}

	public ArrayList<Sach> getSachbyName(String tenSach) {
		String sql = "SELECT * FROM tblsach,tbldanhmucsach WHERE tenSach LIKE'%"
				+ tenSach
				+ "%' AND tblsach.maDanhMucSach=tbldanhmucsach.maDanhMuc;";
		ArrayList<Sach> result = (ArrayList<Sach>) jdbcTemplateObject.query(
				sql, new SachMapper());
		return result;
	}

	private int maxIdSach() {
		int max = 0;
		String sql = "SELECT MAX(maSach) FROM tblsach";
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

	public boolean addSach(Sach sach) {
		sach.setMaSach(maxIdSach() + 1);
		String SQL = "insert into tblsach (maSach,tenSach, tacGia, nhaXuatBan, namXuatBan,image,gia,moTa,maDanhMucSach) values (?,?,?,?,?,?,?,?,?)";
		jdbcTemplateObject.update(SQL, sach.getMaSach(), sach.getTenSach(),
				sach.getTacGia(), sach.getNhaXuatBan(), sach.getNamXuatBan(),
				sach.getImage(), sach.getGia(), sach.getMoTa(), sach
						.getDanhMuc().getMaDanhMuc());
		return true;
	}

	public void deleteSach(int id) {
		String sql1 = "DELETE from tbldatsach where maSach=?";
		jdbcTemplateObject.update(sql1, new Object[] { id });
		String sql = "DELETE from tblsach where maSach=?";
		jdbcTemplateObject.update(sql, new Object[] { id });
	}

	public void updateSach(Sach sach) {
		String sql = "update tblsach set tenSach=?,tacGia=?, nhaXuatBan=?, namXuatBan=?,  image=?, gia=?,moTa=? where maSach=?";
		jdbcTemplateObject.update(
				sql,
				new Object[] { sach.getTenSach(), sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getNamXuatBan(),
						sach.getImage(), sach.getGia(), sach.getMoTa(),
						sach.getMaSach() });
	}

}
