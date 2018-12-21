package quanlycauhoi.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Public.beans.Question;
import Public.conn.ConnectionUtils;
import quanlycauhoi.utils.DBUtils;



/**
 * Servlet implementation class ChiTietCauHoi
 */
@WebServlet("/ChiTietCauHoi")
public class ChiTietCauHoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietCauHoi() {
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
		 
        String MaCauHoi = (String) request.getParameter("MaCauHoi");
 
        Question qt = null;
 
        String errorString = null;
 
        try {
            qt = DBUtils.findQuestion(conn, MaCauHoi);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
      
        if (errorString != null && qt == null) {
            response.sendRedirect(request.getServletPath() + "/QuestionListServlet");
            return;
        }
 

        request.setAttribute("errorString", errorString);
        request.setAttribute("question", qt);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/QuanLiCauHoi/ChiTietCauHoi.jsp");
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
