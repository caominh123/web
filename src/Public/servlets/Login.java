package Public.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Public.beans.User;
import Public.conn.MySQLConnUtils;
import Public.utils.DBUtils;


/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/Login/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = (String) request.getParameter("username");
		String password =(String) request.getParameter("password");
		String role = (String) request.getParameter("role");
	
		User user = null;
		String errorUser = null;
		
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			System.out.println("conection");
		} catch (ClassNotFoundException e1) {
			System.out.println("class not found");
			e1.printStackTrace();
		} catch (SQLException e1) {
			System.out.println("Error conection");
			e1.printStackTrace();
		}
		
		try {
			user = DBUtils.FindUserLogin(conn, username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(user == null || password.equals(user.getPassword()) == false|| role.equals(user.getRole()) == false) {
			
			errorUser = "Invalid username or password or role";
			
			request.setAttribute("errorUser", errorUser);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/Login/login.jsp");
			dispatcher.forward(request, response);
		}
		else {
			
			HttpSession session = request.getSession();
			
			if(user.getRole().equals("QLDT") == true) {
				
				session.setAttribute("userQLDT", user);
				response.sendRedirect(request.getContextPath() + "/NguoiQuanLiDeThi");
			}
			
			if(user.getRole().equals("Thisinh") == true) {
				
				session.setAttribute("userTS", user);
				response.sendRedirect(request.getContextPath() + "/DanhSachMonHoc?MaThanhVien="+user.getUsername());
			}
			

			if(user.getRole().equals("QLCH") == true) {
				
				session.setAttribute("userQLCH", user);
				response.sendRedirect(request.getContextPath() + "/ThongTinTaiKhoan");
			}
			

			if(user.getRole().equals("QLTSL") == true) {
				
				session.setAttribute("userQLTSL", user);
				response.sendRedirect(request.getContextPath() + "/ThongTinTaiKhoanTV");
			}
		}
	}

}
