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
import Public.conn.MySQLConnUtils;
import quanlythisinh.utils.DBUtils;

/**
 * Servlet implementation class DanhSachThanhVien
 */
@WebServlet("/DanhSachThanhVien")
public class DanhSachThanhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DanhSachThanhVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
	        String errorString = null;
	        List<ThanhVien> list = null;
	        try {
	            list = DBUtils.queryThanhVien(conn);
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	        /*ArrayList<Question> lst=new ArrayList<Question>();
	        lst.add(new Question("1","abc","edfd","asdf","asdf","asdf","adsf","asdf","asdf","asdf"));
	        //request.setAttribute("errorString", errorString);*/
	        request.setAttribute("thanhvienList", list);
	         
	        // Forward sang /WEB-INF/views/productListView.jsp
	        RequestDispatcher dispatcher = request.getServletContext()
	                .getRequestDispatcher("/QuanLiThiSinh/DanhSachThanhVien.jsp");
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
