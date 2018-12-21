package thisinh.servlet;

import java.io.IOException;
import java.io.Writer;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.sun.glass.ui.Pixels.Format;

import Public.beans.DeThi;
import Public.beans.MonHoc;
import Public.conn.MySQLConnUtils;
import net.sourceforge.jtds.jdbc.DateTime;
import thisinh.utils.DBUtils;

@WebServlet("/DanhSachDeThiThiSinh")
public class DanhSachDeThiThiSinh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DanhSachDeThiThiSinh() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection conn = null;
		try {
			conn = MySQLConnUtils.getMySQLConnection();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		String MaThanhVien = (String) request.getParameter("MaThanhVien");
		String MaMonHoc = (String) request.getParameter("MaMonHoc");		
		

		//System.out.println(MaThanhVien);
		//System.out.println(MaMonHoc);
		String errorString = null;
		String TenMonHoc = null;
		String ThoiGianHienTai = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		List<DeThi> list = null;
		
		try {
			list = DBUtils.queryDeThi(conn, MaThanhVien, MaMonHoc,ThoiGianHienTai);						
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		try {
			TenMonHoc = DBUtils.findTenMonHoc(conn,MaMonHoc);						
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null && list == null) {
			response.sendRedirect(request.getServletPath() + "/DanhSachDeThiThiSinh");
			return;
		}
		if (errorString != null && TenMonHoc == null) {
			response.sendRedirect(request.getServletPath() + "/DanhSachDeThiThiSinh");
			return;
		}
		/*
		for(int i=0;i<list.size();i++)
        {
        	System.out.println(list.get(i).getSoLanSubmit());
        }*/		   		
		request.setAttribute("errorString", errorString);
		request.setAttribute("MaThanhVien", MaThanhVien);
		request.setAttribute("TenMonHoc", TenMonHoc);
		request.setAttribute("DeThiList", list);
		

		// Forward sang /WEB-INF/views/productListView.jsp
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ThiSinh/danhsachdethi.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
