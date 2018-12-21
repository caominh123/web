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
  <div class=pagemon>
    <div>
      <h3 class = title><br>
        Chọn Môn Thi
      </h3>
    </div>
    <input type="hidden" name="MaThanhVien" Value="${MaThanhVien}">
    <br><br><br><br>
      <div class=block>
			<input type="hidden" name="MaThanhVien" value="${MaThanhVien}">
			<%String test ="a"; %>
			<c:forEach items="${MonHocList}" var="mh" >
					
					<a class="<%=test%>" href="${pageContext.request.contextPath}/DanhSachDeThiThiSinh?MaMonHoc=${mh.maMonHoc}&&MaThanhVien=${MaThanhVien}">${mh.tenMonHoc}</a>
				<%
					if(test=="a") test="b";
					else if(test=="b") test="c";else test="a";
				%>
			</c:forEach>
        
        
       
      </div>

   
  </div>
  
</body>

</html>