package quanlydethi.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import Public.beans.CauHoi;
import Public.beans.DeThi;
import Public.beans.Lop;
import Public.beans.MonHoc;

public class DBUtils {
	
	// Chinh sua de thi
	public static void EditDeThi(Connection conn, DeThi deThi) throws SQLException{
		
		String sql = "UPDATE DeThi SET TenDe=?, SoLanSubmit=?, ThoiGianThi=?, ThoiGianMo=?, ThoiGianDong=?  WHERE MaDe=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, deThi.getTenDe());
		pstm.setInt(2, deThi.getSoLanSubmit());
		pstm.setInt(3, deThi.getThoiGianThi());
		pstm.setString(4, deThi.getThoiGianMo());
		pstm.setString(5, deThi.getThoiGianDong());
		pstm.setString(6, deThi.getMaDe());

		pstm.executeUpdate();
	}
	
	
	
	// Show chi tiet 1 de thi
	public static DeThi ShowDetailDeThi(Connection conn, String maDe) throws SQLException{
		
		String sql = "SELECT TenDe, SoCauHoi, ThoiGianThi, ThoiGianMo, ThoiGianDong, SoLanSubmit FROM DeThi WHERE MaDe=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, maDe);
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()){
			
			int soCauHoi = rs.getInt("SoCauHoi");
			int thoiGianThi = rs.getInt("ThoiGianThi");
			int soLanSubmit = rs.getInt("SoLanSubmit");
			String thoiGianDong = rs.getString("ThoiGianDong").replace(" ", "T");
			String thoiGianMo = rs.getString("ThoiGianMo").replace(" ", "T");
			String tenDe = rs.getString("TenDe");
			
			DeThi deThi = new DeThi();
			deThi.setTenDe(tenDe);
			deThi.setSoCauHoi(soCauHoi);
			deThi.setThoiGianThi(thoiGianThi);
			deThi.setThoiGianMo(thoiGianMo);
			deThi.setThoiGianDong(thoiGianDong);
			deThi.setSoLanSubmit(soLanSubmit);
			
			return deThi;
		}
		
		return null;
	}
	
	//danh sach lop cau 1 de thi len trang danh sach de thi
	public static List<String> ListLop_De(Connection conn, String maDe) throws SQLException{
		
		String sql = "SELECT TenLop FROM De_Lop, Lop WHERE De_Lop.MaLop = Lop.MaLop AND MaDe=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, maDe);
		
		ResultSet rs = pstm.executeQuery();
		
		List<String> listTenMon = new ArrayList<String>();
		
		while(rs.next()) {
			
			String tenMon = rs.getString("TenLop");
			
			listTenMon.add(tenMon);
		}
		
		return listTenMon;
	}
	
	// danh sach chi tiet cau hoi cau hoi cau 1 de thi
	public static List<CauHoi> ListCauHoi_De(Connection conn, String maDe) throws SQLException{
		
		String sql = "SELECT CauHoi.MaCauHoi, NoiDung, CauA, CauB, CauC, CauD, DapAn FROM CauHoi, De_Cau WHERE CauHoi.MaCauHoi = De_Cau.MaCauHoi AND MaDe=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, maDe);
		
		ResultSet rs = pstm.executeQuery();	
		
		List<CauHoi> listCauHoi = new ArrayList<CauHoi>();
		
		while(rs.next()) {
			
			String maCauHoi = rs.getString("MaCauHoi");
			String noiDung = rs.getString("NoiDung");
			String cauA = rs.getString("CauA");
			String cauB = rs.getString("CauB");
			String cauC = rs.getString("CauC");
			String cauD = rs.getString("CauD");
			String dapAn = rs.getString("DapAn");
			
			CauHoi cauHoi = new CauHoi();
			
			cauHoi.setMaCauHoi(maCauHoi);
			cauHoi.setNoiDung(noiDung);
			cauHoi.setCauA(cauA);
			cauHoi.setCauB(cauB);
			cauHoi.setCauC(cauC);
			cauHoi.setCauD(cauD);
			cauHoi.setDapAn(dapAn);
			
			listCauHoi.add(cauHoi);
		}
		
		return listCauHoi;
	}
	
	
	// show danh sach de thi len trang danh sach de thi
	public static List<DeThi> ShowListDeThi(Connection conn) throws SQLException{
		
		String sql = "SELECT MaDe, TenDe, MonHoc FROM DeThi";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		ResultSet rs = pstm.executeQuery();
		
		List<DeThi> listDeThi = new ArrayList<DeThi>();
		
		while(rs.next()) {
			
			String maDe = rs.getString("MaDe");
			String tenDe = rs.getString("TenDe");
			String monHoc = rs.getString("MonHoc");
			
			DeThi deThi = new DeThi();
			
			deThi.setMaDe(maDe);
			deThi.setTenDe(tenDe);
			deThi.setMonHoc(monHoc);
			
			listDeThi.add(deThi);
		}
		
		return listDeThi;
	}
	
	
	
	// show list lop hoc len checkbox trong trang soan de thi
	public static List<Lop> ShowListLopHoc(Connection conn) throws SQLException{
		
		String sql = "SELECT Malop, TenLop, NgayLap FROM Lop";	

        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        
        List<Lop> listLopHoc = new ArrayList<Lop>();
        
        while(rs.next()) {
        	
        	String maLop = rs.getString("MaLop");
        	String tenLop = rs.getString("TenLop");
        	String ngayLap = rs.getString("NgayLap");
        	
        	Lop lopHoc = new Lop(maLop, tenLop, ngayLap);
        	
        	listLopHoc.add(lopHoc);      	      	
        }
        
        return listLopHoc;
	}
	
	
	// show list mon hoc len combobox o trang soan de thi
	public static List<MonHoc> ShowListMonHoc(Connection conn) throws SQLException{
		
		String sql = "SELECT * FROM MonHoc";
		
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        
        List<MonHoc> listMonHoc = new ArrayList<MonHoc>();
        
        while(rs.next()) {
        	
        	String maMon = rs.getString("MaMonHoc");
        	String tenMon = rs.getString("TenMonHoc");
        	
        	MonHoc monHoc = new MonHoc(maMon, tenMon);
        	
        	listMonHoc.add(monHoc);
        }
        
        return listMonHoc;
	}
	
	// Save de thi vao bang DeThi
	public static void LuuDeThi(Connection conn, DeThi deThi) throws SQLException{
		
		String sql = "INSERT INTO DeThi(MaDe, TenDe, MonHoc, SoCauHoi, ThoiGianThi, "
				+ "ThoiGianMo, ThoiGianDong, SoLanSubmit) VALUES(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, deThi.getMaDe());
		pstm.setString(2, deThi.getTenDe());
		pstm.setString(3, deThi.getMonHoc());
		pstm.setInt(4, deThi.getSoCauHoi());
		pstm.setInt(5, deThi.getThoiGianThi());
		pstm.setString(6, deThi.getThoiGianMo());
		pstm.setString(7, deThi.getThoiGianDong());
		pstm.setInt(8, deThi.getSoLanSubmit());
		
		pstm.executeUpdate();
	}
	
	// Save de va cau hoi vao bang De_Cau
	public static void LuuCauHoi_De(Connection conn, DeThi deThi, CauHoi cauHoi) throws SQLException{
		
		String sql = "INSERT INTO De_Cau(MaDe, MaCauHoi) VALUES(?,?)";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, deThi.getMaDe());
		pstm.setString(2, cauHoi.getMaCauHoi());
		
		pstm.executeUpdate();
		
	}
	
	// Save Lop va de vao bang De_Lop
	public static void LuuLop_De(Connection conn, DeThi deThi, String maLop) throws SQLException{
			
			String sql = "INSERT INTO De_Lop(MaDe, MaLop) VALUES(?,?)";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, deThi.getMaDe());
			pstm.setString(2, maLop);
			
			pstm.executeUpdate();
			
	}
	
	
	// Lay ngau nhien cau hoi cho de thi theo mon hoc va muc do
	public static List<CauHoi> ListCauHoi(Connection conn,int soCau, String monHoc, String mucDo) throws SQLException{
		
		String sql = "SELECT MaCauHoi FROM CauHoi, MonHoc	WHERE CauHoi.MaMonHoc = MonHoc.MaMonHoc "
					+ "AND CauHoi.MaMonHoc=? AND MucDo=? ORDER BY RAND() LIMIT ?";
		PreparedStatement pstm = conn.prepareStatement(sql);		
		pstm.setString(1, monHoc);
		pstm.setString(2, mucDo);
		pstm.setInt(3, soCau);
		
		List<CauHoi> listCauHoi = new ArrayList<CauHoi>();
		
		ResultSet rs = pstm.executeQuery();
		
		while(rs.next()) {
			
			String maCauHoi = rs.getString("MaCauHoi");
			
			CauHoi cauHoi = new CauHoi();
			
			cauHoi.setMaCauHoi(maCauHoi);
			
			listCauHoi.add(cauHoi);
		}
		
		return listCauHoi;
	}
	
	
	
	// Delete deThi trong trang danh sach de thi
	public static void DeleteDeThi(Connection conn, String maDe) throws SQLException{
		
		String sql = "DELETE FROM DeThi WHERE MaDe=?";
		
		PreparedStatement pstm = conn.prepareStatement(sql);
		
		pstm.setString(1, maDe);
		
		pstm.executeUpdate();
	}
}
