<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Validation 연습 폼</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h2>Validation 연습 폼</h2>
<form:form modelAttribute="inputRequest">
    <form:input path="name" />
    <form:errors path="name" />
    <input type="submit" />
</form:form>

</body>
</html>