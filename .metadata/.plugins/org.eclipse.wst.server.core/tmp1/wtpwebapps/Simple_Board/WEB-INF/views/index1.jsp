<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	hello world! <br/>
	<a href="<%=request.getContextPath()%>/hello.do">�λ�</a><br/>
	<form action="<%=request.getContextPath()%>/movie.do" method="GET">
		<select name="name">
			<option value="01">���ϵ�</option>
			<option value="02">����</option>
			<option value="03">����ҳ�</option>
		</select>
		<input type="submit" value="Ŭ��">
	</form>
</body>
</html>