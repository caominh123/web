package quanlythisinh.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Public.beans.Lop;
import Public.beans.ThanhVien;

public class DBUtils {

	public static void insertThanhVien(Connection conn, ThanhVien thanhvien) throws SQLException {
	    String sql = "INSERT into ThanhVien ( MaThanhVien,TenThanhVien,NgaySinh,GioiTinh,Email,SoDienThoai,DiaChi,PassWord,HinhAnh) VALUES (?,?,?,?,?,?,?,?,?)";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, thanhvien.getMaThanhVien());
	    pstm.setString(2, thanhvien.getTenThanhVien());
	    pstm.setString(3, thanhvien.getNgaySinh());
	    pstm.setString(4, thanhvien.getGioiTinh());
	    pstm.setString(5, thanhvien.getEmail());
	    pstm.setString(6, thanhvien.getSoDienThoai());
	    pstm.setString(7, thanhvien.getDiaChi());
	    pstm.setString(8, thanhvien.getPassWord());
	    pstm.setString(9, thanhvien.getHinhAnh());
	    
	    pstm.executeUpdate();
	}

	public static List<Lop> queryLop(Connection conn) throws SQLException {
	    String sql = "SELECT * FROM Lop";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    ResultSet rs = pstm.executeQuery();
	    
	    List<Lop> list = new ArrayList<Lop>();
	    
	    while (rs.next()) {
	        String MaLop = rs.getString("MaLop");
	        String TenLop = rs.getString("TenLop");
	        String NgayLap = rs.getString("NgayLap");
	        
	        Lop lop=new Lop();
	        
	        lop.setMaLop(MaLop);
	        lop.setTenLop(TenLop);
	        lop.setNgayLap(NgayLap);
	        
	        list.add(lop);
	    }
	    return list;
	}

	public static List<ThanhVien> queryThanhVien(Connection conn) throws SQLException {
	    String sql = "SELECT * FROM ThanhVien";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    ResultSet rs = pstm.executeQuery();
	    
	    List<ThanhVien> list = new ArrayList<ThanhVien>();
	    
	    while (rs.next()) {
	        String MaThanhVien = rs.getString("MaThanhVien");
	        String TenThanhVien = rs.getString("TenThanhVien");
	        String NgaySinh = rs.getString("NgaySinh");
	        String GioiTinh =rs.getString("GioiTinh");
	        String Email =rs.getString("Email");
	        String SoDienThoai =rs.getString("SoDienThoai");
	        String DiaChi =rs.getString("DiaChi");
	        String PassWord =rs.getString("PassWord");
	        String HinhAnh =rs.getString("HinhAnh");
	        
	        ThanhVien thanhvien = new ThanhVien(MaThanhVien, TenThanhVien, NgaySinh, GioiTinh, Email, SoDienThoai, DiaChi, PassWord, HinhAnh);
	        
	        thanhvien.setMaThanhVien(MaThanhVien);
	        thanhvien.setTenThanhVien(TenThanhVien);
	        thanhvien.setNgaySinh(NgaySinh);
	        thanhvien.setGioiTinh(GioiTinh);
	        thanhvien.setEmail(Email);
	        thanhvien.setSoDienThoai(SoDienThoai);
	        thanhvien.setDiaChi(DiaChi);
	        thanhvien.setPassWord(PassWord);
	        thanhvien.setHinhAnh(HinhAnh);
	        
	        list.add(thanhvien);
	    }
	    return list;
	}

	public static void SuaLop(Connection conn, Lop lop) throws SQLException {
		String sql = "UPDATE Lop SET TenLop= ? WHERE MaLop = ?";
		 
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(2, lop.getMaLop());
	    pstm.setString(1, lop.getTenLop());
	
	    pstm.executeUpdate();
	}

	public static void SuaThanhVien(Connection conn, ThanhVien thanhvien) throws SQLException {
	    String sql = "UPDATE ThanhVien SET TenThanhVien=?,NgaySinh=?,GioiTinh=?, Email=?,SoDienThoai=?,DiaChi=?,PassWord=?,HinhAnh=? WHERE MaThanhVien=?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    
	    pstm.setString(1, thanhvien.getTenThanhVien());
	    pstm.setString(2, thanhvien.getNgaySinh());
	    pstm.setString(3, thanhvien.getGioiTinh());
	    pstm.setString(4, thanhvien.getEmail());
	    pstm.setString(5, thanhvien.getSoDienThoai());
	    pstm.setString(6, thanhvien.getDiaChi());
	    pstm.setString(7, thanhvien.getPassWord());
	    pstm.setString(8, thanhvien.getHinhAnh());
	    pstm.setString(9, thanhvien.getMaThanhVien());
	    pstm.executeUpdate();
	}

	public static void ThemLop(Connection conn, Lop lop) throws SQLException {
		String sql = "INSERT into Lop ( MaLop,TenLop,NgayLap) VALUES (?,?,?)";
		 
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, lop.getMaLop());
	    pstm.setString(2, lop.getTenLop());
	    pstm.setString(3, lop.getNgayLap());
	
	    
	    pstm.executeUpdate();
	}

	public static void ThemTVLop(Connection conn, String MaLop, String MaThanhVien) throws SQLException {
		String sql = "INSERT into Lop_TV (MaThanhVien,MaLop) VALUES (?,?)";
		 
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(2, MaLop);
	    pstm.setString(1, MaThanhVien);
	
	    pstm.executeUpdate();
	}

	public static Lop TimLop(Connection conn, String MaLop) throws SQLException {
	    String sql = "SELECT * FROM Lop where MaLop=?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    pstm.setString(1, MaLop);
	    ResultSet rs = pstm.executeQuery();
	    
	    
	    while (rs.next()) {
	        String TenLop = rs.getString("TenLop");
	        String NgayLap = rs.getString("NgayLap");
	        
	        Lop lop = new Lop(MaLop,TenLop,NgayLap);
	        return lop;
	    }
	    return null;
	}

	public static ThanhVien TimThanhVien(Connection conn, String MaThanhVien) throws SQLException {
	    String sql = "Select * from ThanhVien where MathanhVien=?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, MaThanhVien);
	
	    ResultSet rs = pstm.executeQuery();
	
	    while (rs.next()) {
	    	String TenThanhVien = rs.getString("TenThanhVien");
	        String NgaySinh = rs.getString("NgaySinh");
	        String GioiTinh =rs.getString("GioiTinh");
	        String Email =rs.getString("Email");
	        String SoDienThoai =rs.getString("SoDienThoai");
	        String DiaChi =rs.getString("DiaChi");
	        String PassWord =rs.getString("PassWord");
	        String HinhAnh =rs.getString("HinhAnh");
	        ThanhVien tv = new ThanhVien(MaThanhVien,TenThanhVien,NgaySinh,GioiTinh,Email,SoDienThoai,DiaChi,PassWord,HinhAnh);
	        return tv;
	    }
	    return null;
	}

	public static List<ThanhVien> TimThanhVienConlai(Connection conn, String MaLop) throws SQLException {
	    String sql = "SELECT * FROM ThanhVien WHERE MaThanhVien NOT IN(SELECT MaThanhVien FROM Lop_TV WHERE MaLop=?)";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, MaLop);
	
	    ResultSet rs = pstm.executeQuery();
	
	    List<ThanhVien> list = new ArrayList<ThanhVien>();
	    
	    while (rs.next()) {
	        String MaThanhVien = rs.getString("MaThanhVien");
	        String TenThanhVien = rs.getString("TenThanhVien");
	        String NgaySinh = rs.getString("NgaySinh");
	        String GioiTinh =rs.getString("GioiTinh");
	        String Email =rs.getString("Email");
	        String SoDienThoai =rs.getString("SoDienThoai");
	        String DiaChi =rs.getString("DiaChi");
	        String PassWord =rs.getString("PassWord");
	        String HinhAnh =rs.getString("HinhAnh");
	        
	        ThanhVien thanhvien = new ThanhVien();
	        
	        thanhvien.setMaThanhVien(MaThanhVien);
	        thanhvien.setTenThanhVien(TenThanhVien);
	        thanhvien.setNgaySinh(NgaySinh);
	        thanhvien.setGioiTinh(GioiTinh);
	        thanhvien.setEmail(Email);
	        thanhvien.setSoDienThoai(SoDienThoai);
	        thanhvien.setDiaChi(DiaChi);
	        thanhvien.setPassWord(PassWord);
	        thanhvien.setHinhAnh(HinhAnh);
	        
	        list.add(thanhvien);
	    }
	    return list;
	}

	public static List<ThanhVien> TimThanhVienLop(Connection conn, String MaLop) throws SQLException {
	    String sql = "SELECT * FROM Lop,Lop_TV,ThanhVien "
	    		+ "WHERE Lop_TV.MaThanhVien=ThanhVien.MaThanhVien "
	    		+ "AND Lop_TV.MaLop=Lop.MaLop AND Lop.MaLop=?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, MaLop);
	
	    ResultSet rs = pstm.executeQuery();
	
	    List<ThanhVien> list = new ArrayList<ThanhVien>();
	    
	    while (rs.next()) {
	        String MaThanhVien = rs.getString("MaThanhVien");
	        String TenThanhVien = rs.getString("TenThanhVien");
	        String NgaySinh = rs.getString("NgaySinh");
	        String GioiTinh =rs.getString("GioiTinh");
	        String Email =rs.getString("Email");
	        String SoDienThoai =rs.getString("SoDienThoai");
	        String DiaChi =rs.getString("DiaChi");
	        String PassWord =rs.getString("PassWord");
	        String HinhAnh =rs.getString("HinhAnh");
	        
	        ThanhVien thanhvien = new ThanhVien();
	        
	        thanhvien.setMaThanhVien(MaThanhVien);
	        thanhvien.setTenThanhVien(TenThanhVien);
	        thanhvien.setNgaySinh(NgaySinh);
	        thanhvien.setGioiTinh(GioiTinh);
	        thanhvien.setEmail(Email);
	        thanhvien.setSoDienThoai(SoDienThoai);
	        thanhvien.setDiaChi(DiaChi);
	        thanhvien.setPassWord(PassWord);
	        thanhvien.setHinhAnh(HinhAnh);
	        
	        list.add(thanhvien);
	    }
	    return list;
	}

	public static void XoaLop(Connection conn, String MaLop) throws SQLException {
	    String sql = "DELETE FROM Lop WHERE MaLop = ?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    pstm.setString(1, MaLop);
	
	    pstm.executeUpdate();
	}

	public static void XoaThanhVien(Connection conn, String MaThanhVien) throws SQLException {
	    String sql = "DELETE FROM ThanhVien WHERE MaThanhVien = ?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    pstm.setString(1, MaThanhVien);
	
	    pstm.executeUpdate();
	}

	public static void XoaThanhVienLop(Connection conn, String MaThanhVien, String MaLop) throws SQLException {
	    String sql = "DELETE FROM Lop_TV WHERE MaThanhVien = ? AND MaLop = ?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    pstm.setString(1, MaThanhVien);
	    pstm.setString(2, MaLop);
	
	    pstm.executeUpdate();
	}

}
