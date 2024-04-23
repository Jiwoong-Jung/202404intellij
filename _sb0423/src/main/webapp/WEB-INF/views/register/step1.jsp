<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>회원가입</title>
</head>
<body>
	<h2><spring:message code="term"/></h2>
	<p>약관 내용</p>
	<h2>${value1}</h2>
	<h2>${value2}</h2>
	<form action="step2" method="post">
	<label>
		<input type="checkbox" name="agree" value="true"> 약관 동의
	</label>
	<input type="submit" value="다음 단계" />
	</form>
</body>
</html>
