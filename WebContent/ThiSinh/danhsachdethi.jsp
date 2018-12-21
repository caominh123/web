<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Danh Sách Đề Thi</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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

	<div class= page>
		<h3 class=title>${TenMonHoc}</h3>
		<input type="hidden" name="MaThanhVien" Value="${MaThanhVien}">
		<c:forEach items="${DeThiList}" var="list">
			<div class="col-sm-12">
				<div class="col-sm-8">
					<div class="dethi">
					<p style="color: red">${errorString}</p>
						<h3>Đề ${list.maDe}: ${list.tenDe}</h3>						
						<p>Số Câu: ${list.soCauHoi} - Số Lần Thi Tối Đa: ${list.soLanSubmit} </p>
						<p>Thời Gian Mở: ${list.thoiGianMo} - Thời Gian Đóng: ${list.thoiGianDong} </p>
						
						
					</div>
				</div>
				<div class="col-sm-4">
					<div class = tgt>
						<p>${list.thoiGianThi} Phút</p>
					</div>					
					<a id ="thi" class="vaothi" href="ChiTietDeThiThiSinh?MaDe=${list.maDe}&&MaThanhVien=${MaThanhVien}&&SoLanSubmit=${list.soLanSubmit} ">Vào Thi</a>					
				</div>
			</div>
			<hr class=line>
		</c:forEach>
		
		
			<div class="pagination">
				<a href="#">&laquo;</a> <a class="active" href="#">1</a> <a href="#">2</a>
				<a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">6</a>
				<a href="#">&raquo;</a>
			</div>
		
		
		
</body>
</html>