package model;


public class DatSach {
	private int maDatSach;
	private KhachHang kh;
	private Sach sach;
	private NhanVien nv;
	private int soLuong;
	private long tongTien;
	private String ngayDat;
	private int isCheck;
	
	public DatSach() {
		// TODO Auto-generated constructor stub
	}

	public DatSach(int maDatSach, KhachHang kh, Sach sach, NhanVien nv,
			int soLuong, long tongTien, String ngayDat, int isCheck) {
		super();
		this.maDatSach = maDatSach;
		this.kh = kh;
		this.sach = sach;
		this.nv = nv;
		this.soLuong = soLuong;
		this.tongTien = tongTien;
		this.ngayDat = ngayDat;
		this.isCheck = isCheck;
	}

	public int getMaDatSach() {
		return maDatSach;
	}

	public void setMaDatSach(int maDatSach) {
		this.maDatSach = maDatSach;
	}

	public KhachHang getKh() {
		return kh;
	}

	public void setKh(KhachHang kh) {
		this.kh = kh;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}

	public NhanVien getNv() {
		return nv;
	}

	public void setNv(NhanVien nv) {
		this.nv = nv;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public long getTongTien() {
		return tongTien;
	}

	public void setTongTien(long tongTien) {
		this.tongTien = tongTien;
	}

	public String getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}

	public int isCheck() {
		return isCheck;
	}

	public void setCheck(int isCheck) {
		this.isCheck = isCheck;
	}
}
