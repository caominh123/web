package thisinh.beans;

public class DiemThi {
	private String MaDe;
	private String MaThanhVien;
	private String ThoiGianKT;
	private float Diem;

	public DiemThi(String maDe, String maThanhVien, String thoiGianKT, float diem) {
		super();
		MaDe = maDe;
		MaThanhVien = maThanhVien;
		ThoiGianKT = thoiGianKT;
		Diem = diem;
	}	
	public String getMaDe() {
		return MaDe;
	}
	public void setMaDe(String maDe) {
		MaDe = maDe;
	}	
	public String getMaThanhVien() {
		return MaThanhVien;
	}	
	public void setMaThanhVien(String maThanhVien) {
		MaThanhVien = maThanhVien;
	}

	/**
	 * @return the thoiGianKT
	 */
	public String getThoiGianKT() {
		return ThoiGianKT;
	}

	/**
	 * @param thoiGianKT the thoiGianKT to set
	 */
	public void setThoiGianKT(String thoiGianKT) {
		ThoiGianKT = thoiGianKT;
	}

	/**
	 * @return the diem
	 */
	public float getDiem() {
		return Diem;
	}

	/**
	 * @param diem the diem to set
	 */
	public void setDiem(float diem) {
		Diem = diem;
	}
}
