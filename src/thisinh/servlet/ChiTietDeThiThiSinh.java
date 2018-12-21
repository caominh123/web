package thisinh.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Public.conn.MySQLConnUtils;
import thisinh.utils.DBUtils;
import thisinh.beans.DiemThi;
import Public.beans.DeThi;

@WebServlet("/ChiTietDeThiThiSinh")
public class ChiTietDeThiThiSinh extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	String SoLanSubmitchophep;
	public ChiTietDeThiThiSinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	
	ArrayList<LocalDateTime> TGBD = new ArrayList<>();
	
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
		String MaDe = (String) request.getParameter("MaDe");
        SoLanSubmitchophep = request.getParameter("SoLanSubmit");
		
        float DiemTB =0;
        int SoLanSubmit =0;
		String errorString = null;
		List<thisinh.beans.ChiTietDeThi> list = null;
		try {
			list = DBUtils.queryChiTietDeThi(conn, MaDe);
			DiemTB=DBUtils.DiemTB(conn, MaThanhVien, MaDe);
            SoLanSubmit=DBUtils.SoLanSubmit(conn, MaThanhVien, MaDe);
		} catch (SQLException e) {
			e.printStackTrace();
			errorString = e.getMessage();
		}
		if (errorString != null && list == null) {
            response.sendRedirect(request.getServletPath() + "/DanhSachDeThiThiSinh");
            return;
        }
		String ThoiGianBD = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		LocalDateTime datetime = LocalDateTime.parse(ThoiGianBD, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		TGBD.add(datetime);
		//System.out.print(TGBD.get(0));
		request.setAttribute("DiemTB",DiemTB);
        request.setAttribute("errorString", errorString);
		request.setAttribute("ChiTietDeThiList", list);
		request.setAttribute("MaThanhVien", MaThanhVien);
		request.setAttribute("MaMonHoc", MaMonHoc);
        request.setAttribute("MaDe", MaDe);
        

        if(SoLanSubmit<Integer.parseInt(SoLanSubmitchophep))
        {
        	request.setAttribute("TGBD", TGBD.get(0));
           
        	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/ThiSinh/chitietdethi.jsp");
            dispatcher.forward(request, response);
        }
        else
        {	
        	
        	TGBD.clear();
            
        	RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/ThiSinh/ketquathi.jsp");
            dispatcher.forward(request, response);
           
        }
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		String MaDe = request.getParameter("MaDe");
		String MaThanhVien = (String) request.getParameter("MaThanhVien");
		String ThoiGianKT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
		
		List<thisinh.beans.ChiTietDeThi> dc = null;
		String errorString = null;
        try {
        	dc = DBUtils.queryChiTietDeThi(conn, MaDe);
           
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        
        List<String> da=new ArrayList<String>();
        for (int i=0;i<dc.size();i++)
        {	
			String dapanthisinh =  (String)request.getParameter(String.valueOf(i+1));
			
			if(dapanthisinh==null)
			{
				dapanthisinh="";
			}
			System.out.println(dapanthisinh);
			da.add(dapanthisinh);
			
        }
        float n=0;
        for (int j=0;j<dc.size();j++)
        {       
        	if(da.get(j).equals(dc.get(j).getDapAn().trim()))
        		n++;        	
        }
        float a = (n/dc.size())*10;
        a = (float)Math.round(a*10)/10;
        DiemThi dt = new DiemThi(MaDe,MaThanhVien,ThoiGianKT,a);
        int SoLanSubmit=0;
        float DiemTB=0;
        try {
			SoLanSubmit=DBUtils.SoLanSubmit(conn, MaThanhVien, MaDe);
			DiemTB=DBUtils.DiemTB(conn, MaThanhVien, MaDe);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
        
        
        if(SoLanSubmit<Integer.parseInt(SoLanSubmitchophep))
        {
        	try {
    			DBUtils.ThemDiem(conn, dt);
    			SoLanSubmit=DBUtils.SoLanSubmit(conn, MaThanhVien, MaDe);
    			DiemTB=DBUtils.DiemTB(conn, MaThanhVien, MaDe);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        	request.setAttribute("DiemThi",a);
        }    
        //request.setAttribute("TGBD", TGBD.get(0));
        request.setAttribute("erorstring", errorString);
        request.setAttribute("solanSubmit", SoLanSubmit);
        request.setAttribute("DiemTB",DiemTB);
        request.setAttribute("ChiTietDeThiList", dc);		
		request.setAttribute("MaThanhVien", MaThanhVien);
		request.setAttribute("SoCauHoi", dc.size());
		TGBD.clear();
        //request.setAttribute("MaDe", MaDe);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/ThiSinh/ketquathi.jsp");
        dispatcher.forward(request, response);
	}
        
}


