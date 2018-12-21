package Public.beans;

public class MonHoc {
	private String MaMonHoc;
	private String TenMonHoc;
	
	public MonHoc()
	{
		
	}
	public MonHoc(String MaMonHoc, String TenMonHoc)
	{
		this.MaMonHoc=MaMonHoc;
		this.TenMonHoc=TenMonHoc;

	}
	public String getMaMonHoc() {
		return MaMonHoc;
	}
	public void setMaMonHoc(String maMonHoc) {
		MaMonHoc = maMonHoc;
	}
	public String getTenMonHoc() {
		return TenMonHoc;
	}
	public void setTenMonHoc(String tenMonHoc) {
		TenMonHoc = tenMonHoc;
	}
}
