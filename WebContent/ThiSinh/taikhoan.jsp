<%@ page  pageEncoding="utf-8"%>

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
    <a class="active" href="${pageContext.request.contextPath}/ThongTinThiSinh?MaThanhVien=${MaThanhVien}"><i class="fa fa-fw fa-user"></i> Thông Tin Tài Khoản</a>
    <a  href="${pageContext.request.contextPath}/DanhSachMonHoc?MaThanhVien=${MaThanhVien}"><i class="fa fa-list-ul"></i> Danh Sách Đề Thi</a>
    <a class=sign-out href="DangXuatTS"><i class="fa fa-sign-out"></i> Sign-out</a>
    <div class="search-container">
      <form action="/action_page.php">
        <button type="submit"><i class="fa fa-search"></i></button>
        <input type="text" placeholder="Search.." name="search">
      </form>
    </div>
  </div>
	<div class=pagetk>
		<div class="col-sm-12">
			<div class="col-sm-2">
				<div class="tkleft">
					<img src="images/photo.jpg" alt="Avatar" style="width: 250px">
				</div>
			</div>
			<div class="col-sm-10">
				<div class="tkright">
					<table id = "tk">
						<tr>
							<th>Họ và tên:</th>
							<th style="color: rgb(236, 155, 61)">${requestScope.TaiKhoanList[0].tenThanhVien}</th>
						</tr>
						<tr>
							<td>Ngày Sinh:</td>
							<td style="color: rgb(236, 155, 61)">${requestScope.TaiKhoanList[0].ngaySinh}</td>
						</tr>
						<tr>
							<td>Email:</td>
							<td style="color: rgb(236, 155, 61)">${requestScope.TaiKhoanList[0].email}</td>
						</tr>
						<tr>
							<td>Địa chỉ:</td>
							<td style="color: rgb(236, 155, 61)">${requestScope.TaiKhoanList[0].diaChi}</td>
						</tr>
						<tr>
							<td>Số điện thoại:</td>
							<td style="color: rgb(236, 155, 61)">${requestScope.TaiKhoanList[0].soDienThoai}</td>
						</tr>
						<tr>
							<td>Giới tính:</td>
							<td style="color: rgb(236, 155, 61)">${requestScope.TaiKhoanList[0].gioiTinh}</td>
						</tr>


					</table>
					<!-- <a class = "change_password">Đổi Mật Khẩu</a> -->
				</div>

			</div>
			
		</div>
	</div>
</body>
</html>
