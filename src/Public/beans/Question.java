package Public.beans;

/**
 * @author nqp
 *
 */
public class Question {
	private String MaCauHoi;
	private String MonHoc;
	private String ChuDe;
	private String NoiDung;
	private String CauA;
	private String CauB;
	private String CauC;
	private String CauD;
	private String DapAn;
	private String MucDo;

	public Question() {

	}

	public Question(String MaCauHoi, String MonHoc, String ChuDe, String NoiDung, String CauA, String CauB, String CauC,
			String CauD, String DapAn, String MucDo) {
		super();
		this.MaCauHoi = MaCauHoi;
		this.MonHoc = MonHoc;
		this.ChuDe = ChuDe;
		this.NoiDung = NoiDung;
		this.CauA = CauA;
		this.CauB = CauB;
		this.CauC = CauC;
		this.CauD = CauD;
		this.DapAn = DapAn;
		this.MucDo = MucDo;
	}

	public String getMaCauHoi() {
		return MaCauHoi;
	}

	public void setMaCauHoi(String MaCauHoi) {
		this.MaCauHoi = MaCauHoi;
	}

	public String getMonHoc() {
		return MonHoc;
	}

	public void setMonHoc(String monHoc) {
		this.MonHoc = monHoc;
	}

	public String getChuDe() {
		return ChuDe;
	}

	public void setChuDe(String chuDe) {
		this.ChuDe = chuDe;
	}

	public String getNoiDung() {
		return NoiDung;
	}

	public void setNoiDung(String noiDung) {
		this.NoiDung = noiDung;
	}

	public String getCauA() {
		return CauA;
	}

	public void setCauA(String cauA) {
		this.CauA = cauA;
	}

	public String getCauB() {
		return CauB;
	}

	public void setCauB(String cauB) {
		this.CauB = cauB;
	}

	public String getCauC() {
		return CauC;
	}

	public void setCauC(String cauC) {
		this.CauC = cauC;
	}

	public String getCauD() {
		return CauD;
	}

	public void setCauD(String cauD) {
		this.CauD = cauD;
	}

	public String getDapAn() {
		return DapAn;
	}

	public void setDapAn(String dapAn) {
		this.DapAn = dapAn;
	}

	public String getMucDo() {
		return MucDo;
	}

	public void setMucDo(String mucDo) {
		this.MucDo = mucDo;
	}
	

}
