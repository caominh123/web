package quanlydethi.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
 * Servlet implementation class ChinhSuaDeThi
 */
@WebServlet("/ChinhSuaDeThi")
public class ChinhSuaDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChinhSuaDeThi() {
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
			System.out.println("conection secess");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		DeThi deThi = null;
		
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
			
			request.setAttribute("maDe", maDe);
			request.setAttribute("deThi", deThi);
			
			RequestDispatcher dispatcher = request.getServletContext()
					.getRequestDispatcher("/QuanLiDeThi/chinh-sua-de-thi.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String maDe = (String) request.getParameter("maDe");
		String tenDe = (String) request.getParameter("tenDe");
		String soLanSubmitSt = (String) request.getParameter("soLanSubmit");
		String thoiGianThiSt = (String) request.getParameter("thoiGianThi");
		
		String thoiGianMoSt = (String) request.getParameter("thoiGianMo");
		String thoiGianMo = thoiGianMoSt.replace("T", " ");
		
		String thoiGianDongSt = (String) request.getParameter("thoiGianDong");
		String thoiGianDong = thoiGianDongSt.replace("T", " ");
		
		System.out.println(thoiGianMo);
		
		int soLanSubmit = 0;
		int thoiGianThi = 0;
		
		String errorEditDeThi = null;
		
		try {
			soLanSubmit = Integer.parseInt(soLanSubmitSt);
			thoiGianThi = Integer.parseInt(thoiGianThiSt);
		}catch(Exception e) {
			
			e.printStackTrace();
			errorEditDeThi = e.getMessage();		
		}
		
		DeThi deThi = new DeThi();
		
		deThi.setMaDe(maDe);
		deThi.setTenDe(tenDe);
		deThi.setSoLanSubmit(soLanSubmit);
		deThi.setThoiGianThi(thoiGianThi);
		deThi.setThoiGianMo(thoiGianMo);
		deThi.setThoiGianDong(thoiGianDong);
		
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
		
		try {
			DBUtils.EditDeThi(conn, deThi);
		} catch (SQLException e) {

			e.printStackTrace();
			errorEditDeThi = e.getMessage();
		}
		
		request.setAttribute("errorEditDeThi", errorEditDeThi);
		request.setAttribute("deThi", deThi);
		
		if(errorEditDeThi == null) {
			
			response.sendRedirect(request.getContextPath() + "/DanhSachDeThi");
		}
		else {
			
			RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/QuanLiDeThi/chinh-sua-de-thi.jsp");
            dispatcher.forward(request, response);
		}
	}

}
