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

import Public.beans.MonHoc;

import Public.conn.MySQLConnUtils;
import thisinh.utils.DBUtils;

@WebServlet("/DanhSachMonHoc")
public class DanhSachMonHoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DanhSachMonHoc() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection conn=null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
			//conn = ConnectionUtils.getConnection();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 
        String MaThanhVien = (String) request.getParameter("MaThanhVien");
        
        //System.out.println(MaThanhVien);
        List<MonHoc> mh = null;
 
        String errorString = null;
 
        try {
            mh = DBUtils.queryMonHoc(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        /*
        for(int i=0;i<mh.size();i++)
        {
        	System.out.println(mh.get(i).getTenMonHoc());
        }*/
        if (errorString != null && mh == null) {
            response.sendRedirect(request.getServletPath() + "/login.jsp");
            return;
        }
 

        request.setAttribute("errorString", errorString);
        request.setAttribute("MonHocList",mh);
        request.setAttribute("MaThanhVien", MaThanhVien);
		
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/ThiSinh/danhsachmonhoc.jsp");
        dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
