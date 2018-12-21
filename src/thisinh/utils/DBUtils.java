package thisinh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.sourceforge.jtds.jdbc.DateTime;
import thisinh.beans.ChiTietDeThi;
import Public.beans.DeThi;
import Public.beans.MonHoc;
import Public.beans.ThanhVien;
import thisinh.beans.DiemThi;

public class DBUtils {
	
	public static List<DeThi> queryDeThi(Connection conn, String MaThanhVien, String MaMonHoc, String ThoiGianHienTai) throws SQLException {
		String sql = "SELECT DeThi.MaDe,TenDe,TenMonHoc,SoCauHoi,ThoiGianThi,SoLanSubmit,ThoiGianMo,ThoiGianDong "
				+ "FROM De_Lop,Lop_TV,MonHoc,DeThi "
				+ "WHERE DeThi.MaDe=De_Lop.MaDe AND De_Lop.MaLop=Lop_TV.MaLop AND DeThi.MonHoc=MonHoc.MaMonHoc "
				+ "AND MaThanhVien=? AND DeThi.MonHoc=? AND ? >= ThoiGianMo AND ?<=ThoiGianDong";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, MaThanhVien);
        pstm.setString(2, MaMonHoc);
        pstm.setString(3, ThoiGianHienTai);
        pstm.setString(4, ThoiGianHienTai);
        
		ResultSet rs = pstm.executeQuery();

		List<DeThi> list = new ArrayList<DeThi>();

		while (rs.next()) {
			String MaDe = rs.getString("MaDe");
			String TenDe = rs.getString("TenDe");
			String TenMonHoc = rs.getString("TenMonHoc");			
			int SoCauHoi = rs.getInt("SoCauHoi");
			int ThoiGianThi = rs.getInt("ThoiGianThi");
			int SoLanSubmit = rs.getInt("SoLanSubmit");
			String ThoiGianMo = rs.getString("ThoiGianMo");
			String ThoiGianDong = rs.getString("ThoiGianDong");

			DeThi dethi = new DeThi();

			dethi.setMaDe(MaDe);
			dethi.setTenDe(TenDe);
			dethi.setMonHoc(TenMonHoc);
			dethi.setSoCauHoi(SoCauHoi);
			dethi.setThoiGianThi(ThoiGianThi);
			dethi.setSoLanSubmit(SoLanSubmit);
			dethi.setThoiGianMo(ThoiGianMo);
			dethi.setThoiGianDong(ThoiGianDong);

			list.add(dethi);
			
		}
		return list;
	}

	public static List<ChiTietDeThi> queryChiTietDeThi(Connection conn, String MaDe) throws SQLException {
		String sql = "SELECT TenDe,ThoiGianThi, CauHoi.MaCauHoi,NoiDung,CauA,CauB,CauC,CauD,DapAn FROM De_Cau,CauHoi,DeThi WHERE CauHoi.MaCauHoi=De_Cau.MaCauHoi AND De_Cau.MaDe=DeThi.MaDe AND De_Cau.MaDe =?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, MaDe);
		ResultSet rs = pstm.executeQuery();

		List<ChiTietDeThi> list = new ArrayList<ChiTietDeThi>();

		while (rs.next()) {			
			String TenDe = rs.getString("TenDe");
			String ThoiGianThi = rs.getString("ThoiGianThi");
			String MaCauHoi = rs.getString("MaCauHoi");
			String NoiDung = rs.getString("NoiDung");
			String CauA = rs.getString("CauA");
			String CauB = rs.getString("CauB");
			String CauC = rs.getString("CauC");
			String CauD = rs.getString("CauD");
			String DapAn = rs.getString("DapAn");			

			ChiTietDeThi chiTietDeThi = new ChiTietDeThi(TenDe, ThoiGianThi, MaCauHoi, NoiDung, CauA, CauB, CauC, CauD, DapAn);

			list.add(chiTietDeThi);
		}
		return list;
	}

	public static List<MonHoc> queryMonHoc(Connection conn) throws SQLException {
		String sql = "SELECT * FROM MonHoc";

		PreparedStatement pstm = conn.prepareStatement(sql);

		ResultSet rs = pstm.executeQuery();

		List<MonHoc> list = new ArrayList<MonHoc>();

		while (rs.next()) {
			String TenMonHoc = rs.getString("TenMonHoc");
			String MaMonHoc = rs.getString("MaMonHoc");
			
			MonHoc monhoc = new MonHoc(MaMonHoc, TenMonHoc);

			monhoc.setTenMonHoc(TenMonHoc);
			monhoc.setMaMonHoc(MaMonHoc);

			list.add(monhoc);
		}
		return list;
	}
	public static List<ThanhVien> queryThanhVien(Connection conn,String MaThanhVien) throws SQLException {
		String sql = "SELECT TenThanhVien, NgaySinh, GioiTinh, Email, SoDienThoai, DiaChi "
				+ "FROM ThanhVien WHERE MaThanhVien = ?";

		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, MaThanhVien);
		ResultSet rs = pstm.executeQuery();

		List<ThanhVien> list = new ArrayList<ThanhVien>();

		while (rs.next()) {
			
			String TenThanhVien = rs.getString("TenThanhVien");
			String NgaySinh = rs.getString("NgaySinh");
			String GioiTinh = rs.getString("GioiTinh");
			String Email = rs.getString("Email");
			String SoDienThoai = rs.getString("SoDienThoai");
			String DiaChi = rs.getString("DiaChi");
			
			ThanhVien thanhvien = new ThanhVien(null, TenThanhVien, NgaySinh, GioiTinh, Email, SoDienThoai, DiaChi, null, null);
			thanhvien.setTenThanhVien(TenThanhVien);
			thanhvien.setNgaySinh(NgaySinh);
			thanhvien.setGioiTinh(GioiTinh);
			thanhvien.setEmail(Email);
			thanhvien.setSoDienThoai(SoDienThoai);
			thanhvien.setDiaChi(DiaChi);
			
			

			list.add(thanhvien);
		}
		return list;
	}
	
	public static void ThemDiem(Connection conn, DiemThi dt) throws SQLException {
    	String sql = "INSERT into Thi (MaDe,MaThanhVien,ThoiGianKetThuc,Diem) VALUES (?,?,?,ROUND(?,2))";
    	 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, dt.getMaDe());
        pstm.setString(2, dt.getMaThanhVien());
        pstm.setString(3, dt.getThoiGianKT());
        pstm.setFloat(4, dt.getDiem());
       
        pstm.executeUpdate();
    }
	public static float DiemTB(Connection conn, String MaThanhVien, String MaDe) throws SQLException {
	    String sql = "SELECT ROUND( DiemTB,2)AS DTB FROM DiemTrungBinh WHERE MaDe=? AND MaThanhVien=?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, MaDe);
	    pstm.setString(2, MaThanhVien);
	    ResultSet rs = pstm.executeQuery();
	
	    while (rs.next()) {
	    	float DiemTB = rs.getFloat("DTB");
	        
	        return DiemTB;
	    }
	    return 0;
	}
	public static int SoLanSubmit(Connection conn, String MaThanhVien, String MaDe) throws SQLException {
	    String sql = "SELECT COUNT(ThoiGianKetThuc) AS SoLanSubmit FROM Thi WHERE MaDe=? AND MaThanhVien=?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, MaDe);
	    pstm.setString(2, MaThanhVien);
	    ResultSet rs = pstm.executeQuery();
	
	    while (rs.next()) {
	    	int SoLanSubmit = rs.getInt(1);
	        
	        return SoLanSubmit;
	    }
	    return 0;
	}
	
	public static String findTenMonHoc(Connection conn, String MaMonHoc) throws SQLException {
    	String sql = "SELECT TenMonHoc FROM MonHoc WHERE MaMonHoc=?";
    	 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1,MaMonHoc);
        ResultSet rs = pstm.executeQuery();
        
       if (rs.next()) {
			String TenMonHoc = rs.getString("TenMonHoc");
			
			MonHoc monhoc = new MonHoc(MaMonHoc, TenMonHoc);
			monhoc.setMaMonHoc(MaMonHoc);
			monhoc.setTenMonHoc(TenMonHoc);
			
			return TenMonHoc;
			
        }
       return null;
    }
	
}
