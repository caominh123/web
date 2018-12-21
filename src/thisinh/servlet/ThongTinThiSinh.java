package thisinh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Public.beans.ThanhVien;
import Public.conn.MySQLConnUtils;
import thisinh.utils.DBUtils;
/**
 * Servlet implementation class ThongTinThanhVien
 */
@WebServlet("/ThongTinThiSinh")
public class ThongTinThiSinh extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongTinThiSinh() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String MaThanhVien = (String) request.getParameter("MaThanhVien");
		String errorString = null;
		List<ThanhVien> list = null;
		try {
			list = DBUtils.queryThanhVien(conn, MaThanhVien);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null && list == null) {
			response.sendRedirect(request.getServletPath() + "/ThongTinThiSinh");
			return;
		}
		request.setAttribute("errorString", errorString);
		request.setAttribute("MaThanhVien", MaThanhVien);
		request.setAttribute("TaiKhoanList", list);
		System.out.println(list.get(0).getTenThanhVien());
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ThiSinh/taikhoan.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
