<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Sửa lớp</title>
    <meta name="description" content="Sufee Admin - HTML5 Admin Template">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="apple-touch-icon" href="apple-icon.png">
    <link rel="shortcut icon" href="favicon.ico">

    <link rel="stylesheet" href="assets/css/normalize.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/flag-icon.min.css">
    <link rel="stylesheet" href="assets/css/cs-skin-elastic.css">
    <link rel="stylesheet" href="assets/css/lib/datatable/dataTables.bootstrap.min.css">

    <link rel="stylesheet" href="assets/scss/style.css">

    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>

</head>

<body>
    <!-- Left Panel -->

    <aside id="left-panel" class="left-panel">
        <nav class="navbar navbar-expand-sm navbar-default">

            <div class="navbar-header">
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#main-menu"
                    aria-controls="main-menu" aria-expanded="false" aria-label="Toggle navigation">
                    <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="#"><img src="images/logo.png" alt="Logo"></a>
                <a class="navbar-brand hidden" href="#"><img src="images/logo2.png" alt="Logo"></a>
            </div>

            <div id="main-menu" class="main-menu collapse navbar-collapse">
                <ul class="nav navbar-nav">

                    <li class="menu-item-has-children active dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="menu-icon fa fa-user-md"></i>Admin</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa  fa-user"></i><a href="ThongTinTaiKhoanTV">Thông Tin</a></li>
                            <li><i class="fa fa-sign-out"></i><a href="DangXuatQLTSL">Đăng Xuất</a></li>
                        </ul>
                    </li>

                    <li class="menu-item-has-children active dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="menu-icon fa  fa-book"></i>Thành Viên</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="DanhSachThanhVien">Danh Sách Thành Viên</a></li>
                            <li><i class="fa fa-plus"></i><a href="ThemThanhVien">Tạo Thành Viên</a></li>
                        </ul>
                    </li>
                    
                    <li class="menu-item-has-children active dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="menu-icon fa  fa-book"></i>Lớp</a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="DanhSachLop">Danh Sách Lớp</a></li>
                            <li><i class="fa fa-plus"></i><a href="ThemLop">Tạo Lớp</a></li>
                        </ul>
                    </li>

                </ul>
            </div><!-- /.navbar-collapse -->
        </nav>
    </aside><!-- /#left-panel -->

    <!-- Left Panel -->

    <!-- Right Panel -->

    <div id="right-panel" class="right-panel">

        <!-- Header-->
        <header id="header" class="header">

            <div class="header-menu">

                <div class="col-sm-7">
                    <a id="menuToggle" class="menutoggle pull-left"><i class="fa fa fa-tasks"></i></a>
                    <div class="header-left">
                        <button class="search-trigger"><i class="fa fa-search"></i></button>
                        <div class="form-inline">
                            <form class="search-form">
                                <input class="form-control mr-sm-2" type="text" placeholder="Search ..." aria-label="Search">
                                <button class="search-close" type="submit"><i class="fa fa-close"></i></button>
                            </form>
                        </div>

                        <div class="dropdown for-notification">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="notification"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fa fa-bell"></i>
                            </button>
                        </div>

                        <div class="dropdown for-message">
                            <button class="btn btn-secondary dropdown-toggle" type="button" id="message" data-toggle="dropdown"
                                aria-haspopup="true" aria-expanded="false">
                                <i class="ti-email"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </header><!-- /header -->
        <!-- Header-->

        <div class="content mt-3">
            <div class="animated fadeIn">
                <div class="row">

                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-header">
                                <strong>Sửa lớp</strong>
                            </div>
                            <c:if test="${not empty lop}">
                            <div class="card-body card-block">
                            <p style="color: red;">${errorString}</p>
                                <form action="${pageContext.request.contextPath}/SuaLop" method="post" class="form-horizontal">
                                    <div class="col-lg-6">
                                        <div class="row form-group">
                                        <input type="hidden" name="MaLop" value="${lop.maLop}" />
                                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Mã
                                                    lớp
                                                </label></div>
                                            <div class="col-12 col-md-9"><label for="text-input" class=" form-control-label">${lop.maLop}
                                           
                                                </label></div>
                                        </div>
                                        
                                        <div class="row form-group">
                                        
                                            <div class="col col-md-3"><label for="text-input" class=" form-control-label">Tên
                                                    lớp
                                                </label></div>
                                            <div class="col-12 col-md-9"><input  type="text" id="text-input" name="TenLop" value="${lop.tenLop}"
                                                    class="form-control" style="width: 70%"></div>
                                        </div>
                                    </div>
                                    <div class="col-lg-6">
	                                        <div class="row form-group">
	                                            <div class="col col-md-4"><label for="text-input" class=" form-control-label">Bổ sung thành viên
	                                                  
	                                                </label></div>
	                                            <div class="col-12 col-md-8">
	                                            	<select name="DanhSach" multiple style="width: 100%">
								                    	<option value="0">no select</option>
								                    	<c:forEach items="${thanhvien}" var="tv">
								                    			
								                                <option value="${tv.maThanhVien}">${tv.maThanhVien} ${tv.tenThanhVien}</option>
								                         </c:forEach>
	                    							</select>
	
						                        </div>
	                                    </div>
                                        
                                    </div>
                                	<div class="col-lg-12">
                                        <div class="card-footer">
                                    		<input type="submit" class="btn btn-primary btn-sm" value="Submit"/>
                                    		<a class="btn btn-danger btn-sm" href="DanhSachLop">Cancel</a>
                                    	</div>
                                    </div>   
                                </form>
                            </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div><!-- .animated -->
        </div><!-- .content -->


    </div><!-- /#right-panel -->

    <!-- Right Panel -->


    <script src="assets/js/vendor/jquery-2.1.4.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/main.js"></script>


    <script src="assets/js/lib/data-table/datatables.min.js"></script>
    <script src="assets/js/lib/data-table/dataTables.bootstrap.min.js"></script>
    <script src="assets/js/lib/data-table/dataTables.buttons.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.bootstrap.min.js"></script>
    <script src="assets/js/lib/data-table/jszip.min.js"></script>
    <script src="assets/js/lib/data-table/pdfmake.min.js"></script>
    <script src="assets/js/lib/data-table/vfs_fonts.js"></script>
    <script src="assets/js/lib/data-table/buttons.html5.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.print.min.js"></script>
    <script src="assets/js/lib/data-table/buttons.colVis.min.js"></script>
    <script src="assets/js/lib/data-table/datatables-init.js"></script>


    <script type="text/javascript">
        $(document).ready(function () {
            $('#bootstrap-data-table-export').DataTable();
        });
    </script>


</body>

</html>