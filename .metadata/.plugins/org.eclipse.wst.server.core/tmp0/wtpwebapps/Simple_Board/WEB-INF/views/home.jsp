<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%-- <%@ page session="false" %> --%>

<style>
img {
	border : 20px solid black;
	width : 300px;
	height : 450px;
}
div#movie_frame {
	font-size:15;
	font-style:oblique;
	font-family:monospace;
	padding:30px;
	margin:30px;
	margin-left:45px;
	float: none;
	clear: both;
	overflow: hidden;
}
div.movie_info{
	float : left;
	margin : 20;
}
div#search{
	margin-right:30px;
	font-size : 20px;
	font-weight: bolder;
}
</style>

<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="/resources/script/jquery-3.2.1.min.js"></script>
	<script>
	
	$(document).ready(function(){
		$("#${year}").prop("selected", true);
	});
		/* var year = document.getElementById("${year}");
		year.options[year.options.selectedIndex].selected = true
		 */
	</script>
</head>
<body>
	
	<form method="get" action="/?year=${year}">
		<div id="movie_frame">	
			<div id="search" align="right" >
				연도 : <select name="year" >
					<option id="2" value="2">없음</option>
					<option id="2011" value="2011">2011</option>
					<option id="2012" value="2012">2012</option>
					<option id="2013" value="2013">2013</option>
					<option id="2014" value="2014">2014</option>
					<option id="2015" value="2015">2015</option>
					<option id="2016" value="2016">2016</option>
					<option id="2017" value="2017">2017</option>
				</select>
				<p>영화명 : <input type="text" name="name"></p>
				<input type= "submit" value="검색"  height="20" >
			</div>
			<div>
				<c:forEach items="${boardYear}" var = "board">
					<div class="movie_info">
						<p><a href="/movie?mid=${board.mid }">
							<img src="http://35.194.131.5:9999/files/img/${board.mid}.jpg">
						   </a>
						</p>
						<p>영화명 : ${board.name }</p>					
						<p>개봉일 : ${board.playdate }</p>
						<p>관객수 : ${board.ticket}</p>
						<p>장르 : ${board.genre}</p>
						
					</div>
				</c:forEach>
			</div>
		</div>
		<div align="center" >
			<c:forEach begin="1" end="${boardCnt}" var="i" >
				<input type="submit" name="page" value="${i}" alt="1">
			</c:forEach>
		</div>
	</form>
</body>
</html> 