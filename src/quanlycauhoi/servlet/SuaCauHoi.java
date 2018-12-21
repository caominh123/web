package quanlycauhoi.servlet;

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
import Public.beans.Question;
import Public.conn.ConnectionUtils;
import quanlycauhoi.utils.DBUtils;

/**
 * Servlet implementation class SuaCauHoi
 */
@WebServlet("/SuaCauHoi")
public class SuaCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SuaCauHoi() {
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
		 
        String MaCauHoi = (String) request.getParameter("MaCauHoi");
 
        Question qt = null;
        List<MonHoc> mh= null;
        String errorString = null;
 
        try {
            qt = DBUtils.findQuestion(conn, MaCauHoi);
            mh = DBUtils.queryMonHoc(conn);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
      
        if (errorString != null && qt == null) {
            response.sendRedirect(request.getServletPath() + "/DanhSachCauHoi");
            return;
        }
 
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("question", qt);
        request.setAttribute("monhoc", mh);
        
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/QuanLiCauHoi/SuaCauHoi.jsp");
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
		 
		String MaCauHoi = (String) request.getParameter("MaCauHoi");
        String MonHoc = (String) request.getParameter("MonHoc");
        String ChuDe = (String) request.getParameter("ChuDe");
        String NoiDung = (String) request.getParameter("NoiDung");
        String CauA = (String) request.getParameter("CauA");
        String CauB = (String) request.getParameter("CauB");
        String CauC = (String) request.getParameter("CauC");
        String CauD = (String) request.getParameter("CauD");
        String DapAn = (String) request.getParameter("DapAn");
        String MucDo = (String) request.getParameter("MucDo");
        Question qt = new Question(MaCauHoi, MonHoc, ChuDe, NoiDung, CauA, CauB, CauC,
    			CauD, DapAn, MucDo);
 
        String errorString = null;
 
        try {
            DBUtils.updateQuestion(conn,qt);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
   
        request.setAttribute("errorString", errorString);
        request.setAttribute("question", qt);
 
       
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/SuaCauHoi.jsp");
            dispatcher.forward(request, response);
        }
  
        else {
            response.sendRedirect(request.getContextPath() + "/DanhSachCauHoi");
        }
    }
}


