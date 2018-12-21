package quanlycauhoi.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Public.beans.MonHoc;
import Public.beans.Question;

public class DBUtils {

	public static void deleteQuestion(Connection conn, String MaCauHoi) throws SQLException {
	    String sql = "DELETE FROM cauhoi WHERE MaCauHoi = ?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    pstm.setString(1, MaCauHoi);
	
	    pstm.executeUpdate();
	}

	public static Question findQuestion(Connection conn, String MaCauHoi) throws SQLException {
	    String sql = "SELECT MaCauHoi,TenMonHoc,ChuDe,NoiDung,CauA,CauB,CauC,CauD,DapAn,MucDo "
	    		+ "FROM CauHoi LEFT JOIN MonHoc ON MonHoc.MaMonHoc = CauHoi.MaMonHoc where MaCauHoi=?";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, MaCauHoi);
	 
	    ResultSet rs = pstm.executeQuery();
	
	    while (rs.next()) {
	    	String TenMonHoc = rs.getString("TenMonHoc");
	        String ChuDe = rs.getString("ChuDe");
	        String NoiDung =rs.getString("NoiDung");
	        String CauA =rs.getString("CauA");
	        String CauB =rs.getString("CauB");
	        String CauC =rs.getString("CauC");
	        String CauD =rs.getString("CauD");
	        String DapAn =rs.getString("DapAn");
	        String MucDo =rs.getString("MucDo");
	        Question qt = new Question(MaCauHoi,TenMonHoc,ChuDe,NoiDung,CauA,CauB,CauC,CauD,DapAn,MucDo);
	        return qt;
	    } 
	    return null;
	}
	
	public static void insertQuestion(Connection conn, Question question) throws SQLException {
		
	    String sql = "INSERT INTO CauHoi( MaCauHoi,MaMonHoc,ChuDe,NoiDung,CauA,CauB,CauC,CauD,DapAn,MucDo) VALUES(?,?,?,?,?,?,?,?,?,?)";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, question.getMaCauHoi());
	    pstm.setString(2, question.getMonHoc());
	    pstm.setString(3, question.getChuDe());
	    pstm.setString(4, question.getNoiDung());
	    pstm.setString(5, question.getCauA());
	    pstm.setString(6, question.getCauB());
	    pstm.setString(7, question.getCauC());
	    pstm.setString(8, question.getCauD());
	    pstm.setString(9, question.getDapAn());
	    pstm.setString(10, question.getMucDo());
	    
	
	    pstm.executeUpdate();
	}

	public static List<Question> queryQuestion(Connection conn) throws SQLException {
	    String sql = "SELECT MaCauHoi,TenMonHoc,ChuDe,NoiDung,CauA,CauB,CauC,CauD,DapAn,MucDo FROM CauHoi "
	    		+ "LEFT JOIN MonHoc ON MonHoc.MaMonHoc = CauHoi.MaMonHoc";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    ResultSet rs = pstm.executeQuery();
	    
	    List<Question> list = new ArrayList<Question>();
	    
	    while (rs.next()) {
	        String TenMonHoc = rs.getString("TenMonHoc");
	        String ChuDe = rs.getString("ChuDe");
	        String MaCauHoi = rs.getString("MaCauHoi");
	        String NoiDung =rs.getString("NoiDung");
	        String CauA =rs.getString("CauA");
	        String CauB =rs.getString("CauB");
	        String CauC =rs.getString("CauC");
	        String CauD =rs.getString("CauD");
	        String DapAn =rs.getString("DapAn");
	        String MucDo =rs.getString("MucDo");
	        
	        Question question = new Question();
	        
	        question.setMonHoc(TenMonHoc);
	        question.setChuDe(ChuDe);
	        question.setMaCauHoi(MaCauHoi);
	        question.setNoiDung(NoiDung);
	        question.setCauA(CauA);
	        question.setCauB(CauB);
	        question.setCauC(CauC);
	        question.setCauD(CauD);
	        question.setDapAn(DapAn);
	        question.setMucDo(MucDo);
	        
	        list.add(question);
	    }
	    return list;
	}

	public static void updateQuestion(Connection conn,  Question question) throws SQLException {
	    String sql = "UPDATE CauHoi SET MaMonHoc = ?, ChuDe = ?, NoiDung = ?,CauA=?,CauB=?,CauC=?,CauD=?,DapAn=?,MucDo=? "
	    		+ "WHERE MaCauHoi=? ";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	    pstm.setString(1, question.getMonHoc());
	    pstm.setString(2, question.getChuDe());
	    pstm.setString(3, question.getNoiDung());
	    pstm.setString(4, question.getCauA());
	    pstm.setString(5, question.getCauB());
	    pstm.setString(6, question.getCauC());
	    pstm.setString(7, question.getCauD());
	    pstm.setString(8, question.getDapAn());
	    pstm.setString(9, question.getMucDo());
	    pstm.setString(10, question.getMaCauHoi());
	    
	    pstm.executeUpdate();
	}

	public static List<MonHoc> queryMonHoc(Connection conn) throws SQLException {
	    String sql = "SELECT * FROM MonHoc";
	
	    PreparedStatement pstm = conn.prepareStatement(sql);
	
	    ResultSet rs = pstm.executeQuery();
	    
	    List<MonHoc> list = new ArrayList<MonHoc>();
	    
	    while (rs.next()) {
	        String TenMonHoc = rs.getString("TenMonHoc");
	        String MaMonHoc = rs.getString("MaMonHoc");
	        MonHoc monhoc =new MonHoc();
	        
	        monhoc.setTenMonHoc(TenMonHoc);
	        monhoc.setMaMonHoc(MaMonHoc);
	        
	        
	        list.add(monhoc);
	    }
	    return list;
	}

}
