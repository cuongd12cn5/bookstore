package model;

public class KhachHang {
	private int maKH;
	private String tenKH,diaChi,lienHe,tenDangNhap,matKhau;
	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}

	public KhachHang(int maKH, String tenKH, String diaChi, String lienHe,
			String tenDangNhap, String matKhau) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.lienHe = lienHe;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}

	public int getMaKH() {
		return maKH;
	}

	public void setMaKH(int maKH) {
		this.maKH = maKH;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getLienHe() {
		return lienHe;
	}

	public void setLienHe(String lienHe) {
		this.lienHe = lienHe;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	
}
