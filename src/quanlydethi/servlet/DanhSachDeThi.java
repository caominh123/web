package quanlydethi.servlet;

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

import Public.beans.DeThi;
import Public.conn.ConnectionUtils;
import quanlydethi.utils.DBUtils;

/**
 * Servlet implementation class DanhSachDeThi
 */
@WebServlet("/DanhSachDeThi")
public class DanhSachDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		
		String errorShowListDeThi = null;
		
		List<DeThi> listDeThi = null;
		
		try {
			listDeThi = DBUtils.ShowListDeThi(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorShowListDeThi = e.getMessage();
		}
		
		request.setAttribute("errorShowListDeThi", errorShowListDeThi);
		request.setAttribute("listDeThi", listDeThi);
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/QuanLiDeThi/danh-sach-de-thi.jsp");
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
