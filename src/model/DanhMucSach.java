package model;

public class DanhMucSach {
	private int maDanhMuc;
	private String tenDanhMuc;
	private String moTa;
	
	public DanhMucSach() {
		// TODO Auto-generated constructor stub
	}

	public DanhMucSach(int maDanhMuc, String tenDanhMuc, String moTa) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
		this.moTa = moTa;
	}

	public int getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(int maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
}
