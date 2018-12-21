package Public.beans;

public class Lop {	
	private String MaLop;
	private String TenLop;
	private String NgayLap;
	
	public Lop()
	{
		
	}
	public Lop(String Malop, String TenLop,String NgayLap)
	{
		this.MaLop=Malop;
		this.TenLop=TenLop;
		this.NgayLap=NgayLap;
	}
	public String getMaLop() {
		return MaLop;
	}
	public void setMaLop(String maLop) {
		MaLop = maLop;
	}
	public String getTenLop() {
		return TenLop;
	}
	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}
	public String getNgayLap() {
		return NgayLap;
	}
	public void setNgayLap(String ngayLap) {
		NgayLap = ngayLap;
	}
	

}
