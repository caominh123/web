package Public.beans;

public class CauHoi {

	private String maCauHoi;
	private String monHoc;
	private String noiDung;
	private String cauA;
	private String cauB;
	private String cauC;
	private String cauD;
	private String dapAn;
	
	public CauHoi() {
		
	}
	
	public CauHoi(String maCauHoi, String monHoc, String noiDung, String cauA, String cauB, String cauC, String cauD,
			String dapAn) {
		super();
		this.maCauHoi = maCauHoi;
		this.monHoc = monHoc;
		this.noiDung = noiDung;
		this.cauA = cauA;
		this.cauB = cauB;
		this.cauC = cauC;
		this.cauD = cauD;
		this.dapAn = dapAn;
	}
	public String getMaCauHoi() {
		return maCauHoi;
	}
	public void setMaCauHoi(String maCauHoi) {
		this.maCauHoi = maCauHoi;
	}
	public String getMonHoc() {
		return monHoc;
	}
	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}
	public String getNoiDung() {
		return noiDung;
	}
	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}
	public String getCauA() {
		return cauA;
	}
	public void setCauA(String cauA) {
		this.cauA = cauA;
	}
	public String getCauB() {
		return cauB;
	}
	public void setCauB(String cauB) {
		this.cauB = cauB;
	}
	public String getCauC() {
		return cauC;
	}
	public void setCauC(String cauC) {
		this.cauC = cauC;
	}
	public String getCauD() {
		return cauD;
	}
	public void setCauD(String cauD) {
		this.cauD = cauD;
	}
	public String getDapAn() {
		return dapAn;
	}
	public void setDapAn(String dapAn) {
		this.dapAn = dapAn;
	}
}
