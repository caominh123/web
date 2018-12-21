<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <link rel="stylesheet" href="assets/css/stylethisinh.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>

<body>
    <div class="header">
    <h1>Thi Trắc Nghiệm Online</h1>
  </div>
  <div class="navbar">
    <a  href="${pageContext.request.contextPath}/Home?MaThanhVien=${MaThanhVien}"><i class="fa fa-fw fa-home"></i> Home</a>
    <a href="${pageContext.request.contextPath}/ThongTinThiSinh?MaThanhVien=${MaThanhVien}"><i class="fa fa-fw fa-user"></i> Thông Tin Tài Khoản</a>
    <a class="active" href="${pageContext.request.contextPath}/DanhSachMonHoc?MaThanhVien=${MaThanhVien}"><i class="fa fa-list-ul"></i> Danh Sách Đề Thi</a>
    <a class=sign-out href="DangXuatTS"><i class="fa fa-sign-out"></i> Sign-out</a>
    <div class="search-container">
      <form action="/action_page.php">
        <button type="submit"><i class="fa fa-search"></i></button>
        <input type="text" placeholder="Search.." name="search">
      </form>
    </div>
  </div>

	<div class=pageketqua>
		<h3 class=title>KẾT QUẢ THI</h3>
		<div class="col-sm-12">
			<!-- 
			content of this area will be the content of your PDF file 
			-->
    		<div id="HTMLtoPDF">
    			
				<div class="dethi">
					<h3>De Thi: ${requestScope.ChiTietDeThiList[0].tenDe}</h3>
					<%
						Float DiemThi = (Float) request.getAttribute("DiemThi");
						if (DiemThi == null) {
					%>
					<p>Ban Da Thi Du So Lan Cho Phep</p>
					<p>Diem Trung Binh: ${DiemTB}</p>
					<%
						} else {
					%>
					
					<p>Diem: ${DiemThi}/10</p>
					<p>Da thi: ${solanSubmit} Lan - Diem Trung Binh: ${DiemTB}</p>
					
					<%
						}
					%>					
				</div>
			</div>

    			<!-- here we call the function that makes PDF -->
			<div >
				<a class="vaothi" href="#" onclick="HTMLtoPDF()">Xuất file PDF</a>
			</div>
		</div>
	</div>
	
	
	<script src="assets/js/jspdf.js"></script>
    <script src="assets/js/jquery-2.1.3.js"></script>
    <script src="assets/js/pdfFromHTML.js"></script>
</body>

</html>