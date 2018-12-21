package quanlythisinh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

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
 * Servlet implementation class SuaThanhVien
 */
@WebServlet("/SuaThanhVien")
public class SuaThanhVien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaThanhVien() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
				 
		        String MaThanhVien = (String) request.getParameter("MaThanhVien");
		 
		        ThanhVien tv = null;
		 
		        String errorString = null;
		 
		        try {
		            tv = DBUtils.TimThanhVien(conn, MaThanhVien);
		        } catch (SQLException e) {
		            e.printStackTrace();
		            errorString = e.getMessage();
		        }
		 
		      
		        if (errorString != null && tv == null) {
		            response.sendRedirect(request.getServletPath() + "/DanhSachThanhVien");
		            return;
		        }
		 

		        request.setAttribute("errorString", errorString);
		        request.setAttribute("thanhvien", tv);
		 
		        RequestDispatcher dispatcher = request.getServletContext()
		                .getRequestDispatcher("/QuanLiThiSinh/SuaThanhVien.jsp");
		        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
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
 
        try {
            DBUtils.SuaThanhVien(conn,tv);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        request.setAttribute("errorString", errorString);
        request.setAttribute("thanhvien", tv);
 
       
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/QuanLiThiSinh/SuaThanhVien.jsp");
            dispatcher.forward(request, response);
        }
  
        else {
            response.sendRedirect(request.getContextPath() + "/DanhSachThanhVien");
        }
	}

}
