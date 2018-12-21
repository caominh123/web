package quanlythisinh.servlet;

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
import Public.conn.ConnectionUtils;
import quanlythisinh.utils.DBUtils;

/**
 * Servlet implementation class DanhSachThanhVienLop
 */
@WebServlet("/DanhSachThanhVienLop")
public class DanhSachThanhVienLop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachThanhVienLop() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		try {
			conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
        String MaLop = (String) request.getParameter("MaLop");
 
        List<ThanhVien> tv = null;
 
        String errorString = null;
        
        try {
            tv =  DBUtils.TimThanhVienLop(conn, MaLop);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
      
        if (errorString != null && tv == null) {
            response.sendRedirect(request.getServletPath() + "/DanhSachLop");
            return;
        }
 

        request.setAttribute("errorString", errorString);
        request.setAttribute("thanhvienlop", tv);
        request.setAttribute("MaLop", MaLop);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/QuanLiThiSinh/DanhSachThanhVienLop.jsp");
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
