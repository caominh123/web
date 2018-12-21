package Public.beans;

import java.util.List;

public class DeThi {
	
	private String maDe;
	private String tenDe;
	private String monHoc;
	private int soCauHoi;
	private int thoiGianThi;
	private String thoiGianMo;
	private String thoiGianDong;
	private int soLanSubmit;
	
	public DeThi() {
		
	}

	public DeThi(String maDe, String tenDe, String monHoc, int soCauHoi, int thoiGianThi, String thoiGianMo,
			String thoiGianDong, int soLanSubmit) {
		super();
		this.maDe = maDe;
		this.tenDe = tenDe;
		this.monHoc = monHoc;
		this.soCauHoi = soCauHoi;
		this.thoiGianThi = thoiGianThi;
		this.thoiGianMo = thoiGianMo;
		this.thoiGianDong = thoiGianDong;
		//this.listLopHoc = listLopHoc;
		this.soLanSubmit = soLanSubmit;
		//this.listCauHoi = listCauHoi;
	}

	public String getMaDe() {
		return maDe;
	}

	public void setMaDe(String maDe) {
		this.maDe = maDe;
	}

	public String getTenDe() {
		return tenDe;
	}

	public void setTenDe(String tenDe) {
		this.tenDe = tenDe;
	}

	public String getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(String monHoc) {
		this.monHoc = monHoc;
	}

	public int getSoCauHoi() {
		return soCauHoi;
	}

	public void setSoCauHoi(int soCauHoi) {
		this.soCauHoi = soCauHoi;
	}

	public int getThoiGianThi() {
		return thoiGianThi;
	}

	public void setThoiGianThi(int thoiGianThi) {
		this.thoiGianThi = thoiGianThi;
	}

	public String getThoiGianMo() {
		return thoiGianMo;
	}

	public void setThoiGianMo(String thoiGianMo) {
		this.thoiGianMo = thoiGianMo;
	}

	public String getThoiGianDong() {
		return thoiGianDong;
	}

	public void setThoiGianDong(String thoiGianDong) {
		this.thoiGianDong = thoiGianDong;
	}

	
	public int getSoLanSubmit() {
		return soLanSubmit;
	}
	
	public void setSoLanSubmit(int soLanSubmit) {
		this.soLanSubmit = soLanSubmit;
	}
}
