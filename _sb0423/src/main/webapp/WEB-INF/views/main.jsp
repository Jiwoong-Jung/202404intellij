<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>메인</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
    <p>환영합니다.</p>
    <p><a href="<c:url value="/register/step1" />">[회원 가입하기]</a>
    <p><a href="<c:url value="/register/list" />">[회원 목록]</a>
</body>
</html>
