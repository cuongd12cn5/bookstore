package model;

public class NhanVien {
	private int maNV;
	private String tenNV,diaChi,lienHe,viTri,tenDangNhap,matKhau;
	private int quyen; //Quyền nhân viên 
	 
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}

	public NhanVien(int maNV, String tenNV, String diaChi, String lienHe,
			String viTri, String tenDangNhap, String matKhau, int quyen) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.diaChi = diaChi;
		this.lienHe = lienHe;
		this.viTri = viTri;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.quyen = quyen;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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

	public String getViTri() {
		return viTri;
	}

	public void setViTri(String viTri) {
		this.viTri = viTri;
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

	public int getQuyen() {
		return quyen;
	}

	public void setQuyen(int quyen) {
		this.quyen = quyen;
	}
	
}
