<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page session="false" %> --%>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>후기</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.num}</td>
					<td>${board.comments}</td>
					<td>${board.regdate}</td>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
