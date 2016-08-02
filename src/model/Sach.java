package model;

public class Sach {
	private int maSach;
	private String tenSach,tacGia,nhaXuatBan;
	private int namXuatBan;
	private String image;
	private long gia;
	private String moTa;
	private DanhMucSach danhMuc;
	
	public Sach() {
		// TODO Auto-generated constructor stub
	}

	public Sach(int maSach, String tenSach, String tacGia, String nhaXuatBan,
			int namXuatBan, String image, long gia, String moTa,
			DanhMucSach danhMuc) {
		super();
		this.maSach = maSach;
		this.tenSach = tenSach;
		this.tacGia = tacGia;
		this.nhaXuatBan = nhaXuatBan;
		this.namXuatBan = namXuatBan;
		this.image = image;
		this.gia = gia;
		this.moTa = moTa;
		this.danhMuc = danhMuc;
	}

	public int getMaSach() {
		return maSach;
	}

	public void setMaSach(int maSach) {
		this.maSach = maSach;
	}

	public String getTenSach() {
		return tenSach;
	}

	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public int getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public DanhMucSach getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(DanhMucSach danhMuc) {
		this.danhMuc = danhMuc;
	}

}
