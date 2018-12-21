package Public.beans;

import java.sql.Date;

public class ThanhVien {
	private String MaThanhVien;
	private String TenThanhVien;
	private String NgaySinh;
	private String GioiTinh;
	private String Email;
	private String SoDienThoai;
	private String DiaChi;
	private String PassWord;
	private String HinhAnh;
	
	
	public ThanhVien(String MaThanhVien, String TenThanhVien, String NgaySinh,String GioiTinh, String Email, String SoDienThoai, String DiaChi, String PassWord, String HinhAnh) 
	{
		super();
		this.MaThanhVien= MaThanhVien;
		this.TenThanhVien= TenThanhVien;
		this.NgaySinh = NgaySinh;
		this.GioiTinh = GioiTinh;
		this.Email= Email;
		this.SoDienThoai= SoDienThoai;
		this.DiaChi= DiaChi;
		this.PassWord= PassWord;
		this.HinhAnh= HinhAnh;
	}
	public ThanhVien() {
	
	}
	public String getMaThanhVien() {
		return MaThanhVien;
	}
	public void setMaThanhVien(String maThanhVien) {
		this.MaThanhVien = maThanhVien;
	}
	public String getTenThanhVien() {
		return TenThanhVien;
	}
	public void setTenThanhVien(String tenThanhVien) {
		this.TenThanhVien = tenThanhVien;
	}
	public String getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.NgaySinh = ngaySinh;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.GioiTinh = gioiTinh;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		this.Email = email;
	}
	public String getSoDienThoai() {
		return SoDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.SoDienThoai = soDienThoai;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		this.DiaChi = diaChi;
	}
	public String getPassWord() {
		return PassWord;
	}
	public void setPassWord(String passWord) {
		this.PassWord = passWord;
	}
	public String getHinhAnh() {
		return HinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.HinhAnh = hinhAnh;
	}
	
	
}
