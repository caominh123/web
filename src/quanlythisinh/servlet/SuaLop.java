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

import Public.beans.Lop;
import Public.beans.ThanhVien;
import Public.conn.ConnectionUtils;
import quanlythisinh.utils.DBUtils;

/**
 * Servlet implementation class SuaLop
 */
@WebServlet("/SuaLop")
public class SuaLop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaLop() {
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
		 
		String MaLop = (String)request.getParameter("MaLop");
		Lop lop = null;
        List<ThanhVien> tv = null;
 
        String errorString = null;
 
        try {
        	lop = DBUtils.TimLop(conn, MaLop);
            tv = DBUtils.TimThanhVienConlai(conn, MaLop);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
      
        if (errorString != null && tv == null) {
            response.sendRedirect(request.getServletPath() + "/DanhSachLop");
            return;
        }
 

        request.setAttribute("errorString", errorString);
        request.setAttribute("lop", lop);
        request.setAttribute("thanhvien", tv);
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/QuanLiThiSinh/SuaLop.jsp");
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
		 
		String MaLop = (String) request.getParameter("MaLop");
        String TenLop = (String) request.getParameter("TenLop");
        String NgayLap = (String) request.getParameter("NgayLap");
        
        String[] dsthanhvien = request.getParameterValues("DanhSach");
        
        if(dsthanhvien!=null)
        {
	        if(dsthanhvien[0].equalsIgnoreCase("0"))
	        {
	        	dsthanhvien=null;
	        }
        }
        
        Lop lop = new Lop(MaLop, TenLop, NgayLap);
 
        String errorString = null;
 
        try {
            DBUtils.SuaLop(conn,lop);
            if(dsthanhvien!=null)
            {

            	for (String tv : dsthanhvien) {
            
           	 
            	DBUtils.ThemTVLop(conn, MaLop, tv);
     
            	}
            }
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        request.setAttribute("errorString", errorString);
        request.setAttribute("lop", lop);
 
       
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/QuanLiThiSinh/SuaLop.jsp");
            dispatcher.forward(request, response);
        }
  
        else {
            response.sendRedirect(request.getContextPath() + "/DanhSachLop");
        }
	}

}
