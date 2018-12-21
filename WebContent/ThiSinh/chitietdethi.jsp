<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Nhân Đa Thức Với Đơn Thức</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
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
  	
		<form method="POST"	action="${pageContext.request.contextPath}/ChiTietDeThiThiSinh">
			<div class=page>
				<h3 class=title>${requestScope.ChiTietDeThiList[0].tenDe}</h3>

				<div class="col-sm-12">
					<div class="col-sm-8">
						<div id="cauhoi" class="dethi">
							<input type="hidden" name="MaDe" value="${MaDe}"> 
							<input type="hidden" name="MaThanhVien" value="${MaThanhVien}">																												
							<%								
								int i = 1;								
							%>
							<c:forEach items="${ChiTietDeThiList}" var="list">
								<div class="radio">
									<p class=socau>
										<u>Câu <%=i%>:</u>
									<p class=tencau>${list.noiDung}</p>
									<div class=dapan>
										<input type="radio" value="CauA" name="<%=i%>" /> A. ${list.cauA} <br /> 
										<input type="radio" value="CauB" name="<%=i%>" /> B. ${list.cauB} <br /> 
										<input type="radio"	value="CauC" name="<%=i%>" /> C. ${list.cauC} <br /> 
										<input type="radio" value="CauD" name="<%=i%>" /> D. ${list.cauD}
									</div>
								</div>
								<%
									i++;
								%>
							</c:forEach>
						</div>
					</div>
					<div class="col-sm-4">
						<div class = dethiright>
						<div class=time>
							<h4>Thời Gian Còn Lại:</h4>
							<h2>
								<span id="time">${requestScope.ChiTietDeThiList[0].thoiGianThi}</span>
								
							</h2>
						</div>


						<div id="answer" class="answered_block">
							<div class="title-answered">CÁC CÂU ĐÃ LÀM</div>
							<%
								int j = 1;
							%>
							<c:forEach items="${ChiTietDeThiList}" var="list">
								<div class="answered_item"><%=j%></div>

								<%
									j++;
								%>
							</c:forEach>
						</div>
						
							<input id="myBtn" type="submit" class="submit" value="NỘP BÀI">
					
					</div>
					</div>
				</div>
				<p id ="TGBD" style="visibility: hidden;" >${TGBD}</p>
				<div class="pagination">
					<a class="pre" href="#">❮ Previous</a>
					<a class="next" href="#">Next❯</a>
				</div>
				
			</div>
		</form>
		
		<script>
				function startTimer(duration, display, start) {
		            var diff,
		              minutes,
		              seconds;
		            
		            function timer() {
		              // get the number of seconds that have elapsed since 
		              // startTimer() was called
		              diff = duration -(((Date.now() - start) / 1000) | 0);
						
		              // does the same job as parseInt truncates the float
		              minutes = (diff / 60) | 0;
		              seconds = (diff % 60) | 0;

		              minutes = minutes < 10 ? "0" + minutes : minutes;
		              seconds = seconds < 10 ? "0" + seconds : seconds;

		              display.textContent = minutes + ":" + seconds;

		              if (diff <= 0) {
		                // add one second so that the count down starts at the full duration
		                // example 05:00 not 04:59
		                //start = Date.now() + 1000;
		                x.click("NỘP BÀI")
		              }
		            };
		            // we don't want to wait a full second before the timer starts
		            timer();
		            setInterval(timer, 1000);
		          }
				//System.out.println(start);
		          window.onload = function () {
		        	var test = document.getElementById("TGBD").innerHTML;
		        	var start = Date.parse(test);
		        
		            var myElement = document.getElementById("time");
		            var fiveMinutes = 60 * myElement.innerHTML,
		            display = document.querySelector('#time');
		            startTimer(fiveMinutes, display, start);
		          };
			</script>
			<script>
			
			    var x = document.getElementById("myBtn");
			    x.addEventListener("click", myFunction);
			
			
			    function myFunction() {
			      alert("ĐÃ NỘP BÀI");
			    }
			
			
			 
			</script>
			<script>
				$("input[type='radio']").click(function(e){
					var temp=$(this).parent().parent().index();
					$("#answer").children().eq(temp-1).addClass("active");
				})
				
			</script>
			<script>
				$("input[type='radio']").click(function(e){
					$(this).attr('checked', true);				
				})				
			</script>
			

</body>
</html>