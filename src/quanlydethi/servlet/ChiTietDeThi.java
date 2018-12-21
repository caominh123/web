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

import Public.beans.CauHoi;
import Public.beans.DeThi;
import Public.conn.ConnectionUtils;
import quanlydethi.utils.DBUtils;

/**
 * Servlet implementation class ChiTietDeThi
 */
@WebServlet("/ChiTietDeThi")
public class ChiTietDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietDeThi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String maDe = (String) request.getParameter("maDe");
		
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
		
		DeThi deThi = null;
		List<String> listTenLop = null;
		List<CauHoi> listCauHoi = null;
		
		try {
			deThi = DBUtils.ShowDetailDeThi(conn, maDe);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(deThi == null) {
			response.sendRedirect(request.getContextPath() + "/DanhSachDeThi");
		}
		else {
			try {
				listTenLop = DBUtils.ListLop_De(conn, maDe);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				listCauHoi = DBUtils.ListCauHoi_De(conn, maDe);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("deThi", deThi);
			request.setAttribute("listTenLop", listTenLop);
			request.setAttribute("listCauHoi", listCauHoi);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/QuanLiDeThi/chi-tiet-de-thi.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
