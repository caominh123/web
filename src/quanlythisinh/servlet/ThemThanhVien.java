package quanlythisinh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Public.beans.ThanhVien;
import Public.conn.ConnectionUtils;
import quanlythisinh.utils.DBUtils;

/**
 * Servlet implementation class ThemThanhVien
 */
@WebServlet("/ThemThanhVien")
public class ThemThanhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ThemThanhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/QuanLiThiSinh/ThemThanhVien.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Connection conn = null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String MaThanhVien = (String) request.getParameter("MaThanhVien");
		String TenThanhVien = (String) request.getParameter("TenThanhVien");
		String NgaySinh = (String) request.getParameter("NgaySinh");
		String GioiTinh = (String) request.getParameter("GioiTinh");
		String Email = (String) request.getParameter("Email");
		String SoDienThoai = (String) request.getParameter("SoDienThoai");
		String DiaChi = (String) request.getParameter("DiaChi");
		String PassWord = (String) request.getParameter("PassWord");
		String HinhAnh = (String) request.getParameter("HinhAnh");

		ThanhVien tv = new ThanhVien(MaThanhVien, TenThanhVien, NgaySinh, GioiTinh, Email, SoDienThoai, DiaChi,
				PassWord, HinhAnh);

		String errorString = null;

		String regex = "\\w+";

		if (MaThanhVien == null || !MaThanhVien.matches(regex)) {
			errorString = "MaThanhVien invalid!";
		}

		if (errorString == null) {
			try {
				DBUtils.insertThanhVien(conn, tv);
			} catch (SQLException e) {
				e.printStackTrace();
				errorString = e.getMessage();
			}
		}

		request.setAttribute("errorString", errorString);
		request.setAttribute("thanhvien", tv);

		if (errorString != null) {
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/QuanLiThiSinh/ThemThanhVien.jsp");
			dispatcher.forward(request, response);
		}

		else {
			response.sendRedirect(request.getContextPath() + "/DanhSachThanhVien");
		}
	}

}
