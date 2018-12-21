<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
<!doctype html>
<html class="no-js" lang="">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Chi Tiết Đề Thi</title>
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
                            <li><i class="fa  fa-user"></i><a href="NguoiQuanLiDeThi">Thông Tin</a></li>
                            <li><i class="fa fa-sign-out"></i><a href="DangXuatQLDT">Đăng Xuất</a></li>
                        </ul>
                    </li>

                    <li class="menu-item-has-children active dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="menu-icon fa  fa-book"></i>Đề Thi </a>
                        <ul class="sub-menu children dropdown-menu">
                            <li><i class="fa fa-table"></i><a href="DanhSachDeThi">Danh Sách Đề Thi</a></li>
                            <li><i class="fa fa-plus"></i><a href="SoanDeThi">Soạn Đề Thi</a></li>
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
                <div class="card-header">
                    <strong class="card-title">Đề Thi ABC</strong>
                </div>
                <div class="row">

                    <div class="col-lg-6">
                        <div class="col col-md-5">
                            <label for="" class="form-control-label">Danh Sách Lớp</label>
                        </div>
                        <div class="card-body" style="overflow: scroll; height:125px; width:300px;">
                            <div class="row form-group">
                            <c:forEach items="${listTenLop}" var="tenLop">
                                <div class="col col-md-12">
                                    <label for="" class="form-control-label"><li class="fa fa-caret-right"></li>${tenLop}</label>                            
                                </div>
                             </c:forEach>
                            </div>
                        </div>

                    </div>
                    <div class="col-lg-6">
                        <div class="card-body card-block">
                            <div class="row form-group">
                                <div class="col col-md-5">
                                    <label for="" class="form-control-label">Thời gian mở</label>
                                </div>
                                <div class="col col-md-7">
                                    <label for="" class="form-control-label">${deThi.thoiGianMo}</label>
                                </div>
                                <div class="col col-md-5">
                                    <label for="" class="form-control-label">Thời gian đóng</label>
                                </div>
                                <div class="col col-md-7">
                                    <label for="" class="form-control-label">${deThi.thoiGianDong}</label>
                                </div>
                                <div class="col col-md-5">
                                    <label for="" class="form-control-label">Số lần submit</label>
                                </div>
                                <div class="col col-md-7">
                                    <label for="" class="form-control-label">${deThi.soLanSubmit}</label>
                                </div>
                                <div class="col col-md-5">
                                    <label for="" class="form-control-label">Thời gian làm bài</label>
                                </div>
                                <div class="col col-md-7">
                                    <label for="" class="form-control-label">${deThi.thoiGianThi}</label>
                                </div>
                                <div class="col col-md-5">
                                    <label for="" class="form-control-label">Số câu</label>
                                </div>
                                <div class="col col-md-7">
                                    <label for="" class="form-control-label">${deThi.soCauHoi}</label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body card-block" style="overflow: scroll; height:350px; width:950px;">
                            <c:forEach items="${listCauHoi}" var="cauHoi">
                                <div class="row form-group">
                                    <div class="col col-md-3">
                                        <label for="" class="form-control-label">Câu hỏi:</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <p class="form-control-static">${cauHoi.noiDung}</p>
                                    </div>
                                    <div class="col col-md-3">
                                        <label for="" class="form-control-label"> A</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <p class="form-control-static">${cauHoi.cauA}</p>
                                    </div>
                                    <div class="col col-md-3">
                                        <label for="" class="form-control-label">B</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <p class="form-control-static">${cauHoi.cauB}</p>
                                    </div>
                                    <div class="col col-md-3">
                                        <label for="" class="form-control-label">C</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <p class="form-control-static">${cauHoi.cauC}</p>
                                    </div>
                                    <div class="col col-md-3">
                                        <label for="" class="form-control-label">D</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <p class="form-control-static">${cauHoi.cauD}</p>
                                    </div>
                                    <div class="col col-md-3">
                                        <label for="" class="form-control-label">Đáp án</label>
                                    </div>
                                    <div class="col-12 col-md-9">
                                        <p class="form-control-static">${cauHoi.dapAn}</p>
                                    </div>
                                </div>
    						</c:forEach>
                            </div>
                        </div>

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