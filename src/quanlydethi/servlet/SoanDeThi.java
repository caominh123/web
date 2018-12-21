package quanlydethi.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Public.beans.CauHoi;
import Public.beans.DeThi;
import Public.beans.Lop;
import Public.beans.MonHoc;
import Public.conn.ConnectionUtils;
import quanlydethi.utils.DBUtils;

/**
 * Servlet implementation class SoanDeThi
 */
@WebServlet("/SoanDeThi")
public class SoanDeThi extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SoanDeThi() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
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
		
		String errorShowLop = null;
		String errorShowMon = null;
		
		List<MonHoc> listMonHoc = null;
		List<Lop> listLopHoc = null;
		
		try {
			listLopHoc = DBUtils.ShowListLopHoc(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorShowLop = "error show LopHoc";
		}
		
		try {
			listMonHoc = DBUtils.ShowListMonHoc(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorShowMon = "error show MonHoc";
		}
		
		request.setAttribute("errorShowMon", errorShowMon);
		request.setAttribute("errorShowLop", errorShowLop);
		
		request.setAttribute("listLopHoc", listLopHoc);
		request.setAttribute("listMonHoc", listMonHoc);
		
		RequestDispatcher dispatcher = request.getServletContext()
				.getRequestDispatcher("/QuanLiDeThi/soan-de-thi.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String maDe = (String) request.getParameter("maDe");
		String tenDe = (String) request.getParameter("tenDe");
		String soCauHoiSt = (String) request.getParameter("soCauHoi");
		String thoiGianLamBaiSt = (String) request.getParameter("thoiGianLamBai");
		
		String thoiGianMoSt = (String) request.getParameter("thoiGianMo");
		String thoiGianMo = thoiGianMoSt.replace("T", " ");
		
		String thoiGianDongSt = (String) request.getParameter("thoiGianDong");
		String thoiGianDong = thoiGianDongSt.replace("T", " ");
		
		String soLanSubmitSt = (String) request.getParameter("soLanSubmit");
		String monHoc = (String) request.getParameter("monHoc");
		
		String soCauDeSt = (String) request.getParameter("soCauDe");
		String soCauTrungBinhSt = (String) request.getParameter("soCauTrungBinh");
		String soCauKhoSt = (String) request.getParameter("soCauKho");
		
		String[] dsLopHoc = request.getParameterValues("maLop");
		
		int soCauHoi = 0;
		int thoiGianLamBai = 0;
		int soLanSubmit = 0;
		int soCauDe = 0;
		int soCauTrungBinh = 0;
		int soCauKho = 0; 
		
		try {
			soCauHoi = Integer.parseInt(soCauHoiSt);
			thoiGianLamBai = Integer.parseInt(thoiGianLamBaiSt);
			soLanSubmit = Integer.parseInt(soLanSubmitSt);
			soCauDe = Integer.parseInt(soCauDeSt);
			soCauTrungBinh = Integer.parseInt(soCauTrungBinhSt);
			soCauKho = Integer.parseInt(soCauKhoSt);
			
		}catch(Exception e) {
			
		}
		
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
		
		String errorSoanDe = null;
		DeThi deThi = new DeThi(maDe, tenDe, monHoc, soCauHoi, thoiGianLamBai, thoiGianMo, thoiGianDong, soLanSubmit);
		
		try {
			DBUtils.LuuDeThi(conn, deThi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorSoanDe = e.getMessage();
		}
		
		List<CauHoi> listCauHoi = new ArrayList<CauHoi>();
		
		List<CauHoi> listCauHoiDe = null;
		List<CauHoi> listCauHoiTrungBinh = null;
		List<CauHoi> listCauHoiKho = null;
		
		try {
			listCauHoiDe = DBUtils.ListCauHoi(conn, soCauDe, monHoc, "De");
			listCauHoiTrungBinh = DBUtils.ListCauHoi(conn, soCauTrungBinh, monHoc, "Trung binh");
			listCauHoiKho = DBUtils.ListCauHoi(conn, soCauKho, monHoc, "Kho");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			errorSoanDe = e.getMessage();
		}
		
		if(errorSoanDe == null) {
			
			listCauHoi.addAll(listCauHoiDe);
			listCauHoi.addAll(listCauHoiTrungBinh);
			listCauHoi.addAll(listCauHoiKho);
			
			for(CauHoi i : listCauHoi) {
				//System.out.println(i.getMaCauHoi());
				try {
					DBUtils.LuuCauHoi_De(conn, deThi, i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					errorSoanDe = "error add Cau_De";
				}
			}
			
			for(String i : dsLopHoc) {
				
				try {
					DBUtils.LuuLop_De(conn, deThi, i);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					errorSoanDe = "error add Lop_De";
				}
			}
			
			if(errorSoanDe == null) {
				
				response.sendRedirect(request.getContextPath() + "/DanhSachDeThi");
			}
			else {
				
				response.sendRedirect(request.getContextPath() + "/SoanDeThi");
			}
		}
		else {
			
			response.sendRedirect(request.getContextPath() + "/SoanDeThi");
		}
	}

}
