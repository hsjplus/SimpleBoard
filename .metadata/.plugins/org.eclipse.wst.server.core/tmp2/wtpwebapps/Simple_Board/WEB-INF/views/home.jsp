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
div#movie_frame{
	font-size:15;
	font-style:oblique;
	font-family:monospace;
	padding:30px;
	margin:30px;
	margin-left:45px;
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
</head>
<body>
	
	<form method="get"  action="/boardList">
		<div id="movie_frame" >	
			<div id="search" align="right" >
				연도 : <select name="year" >
					<option value="">없음</option>
					<option value="2011">2011</option>
					<option value="2012">2012</option>
					<option value="2013">2013</option>
					<option value="2014">2014</option>
					<option value="2015">2015</option>
					<option value="2016">2016</option>
					<option value="2017">2017</option>
				</select>
				<p>영화명 : <input type="text" name="name" value=""></p>
				<input type="submit" value="검색"  height="20" >
				<!-- <input type="hidden" alt = "1" name="page" > -->
			</div>
		
			<c:forEach items="${boardYear}" var = "board">
				<div class="movie_info">
					<p><a href="/movie?mid=${board.mid }">
						<img src="http://35.194.131.5:9999/files/img/${board.mid}.jpg">
						 </a>
					</p>
					<p>영화명 : ${board.name }</p>					
					<p>관객수 : ${board.ticket }</p>
					<p>장르 : ${board.genre }</p>
				</div>
			</c:forEach>
			<c:forEach begin="1" end="10" var="i"  >
			<input type="submit" name="page"  value="${i }"alt="1">
			
			</c:forEach>
		</div>
	</form>
</body>
</html> 