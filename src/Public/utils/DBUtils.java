package Public.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Public.beans.User;

public class DBUtils {
	
	// tim tai khoan user de kiem tra dang nhap
		public static User FindUserLogin(Connection conn, String username) throws SQLException{
			
			String sql = "SELECT UserName, PassWord, Role FROM users WHERE UserName=?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, username);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				
				String username1 = rs.getString("UserName");
				String password = rs.getString("PassWord");
				String role = rs.getString("Role");
				
				User user = new User(username1, password, role);
				
				return user;
			}
			
			return null;
			
		}
}
