<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>회원목록</title>
</head>
<body>
<table border="1">
    <tr>
        <th>ID</th><th>EMAIL</th><th>이름</th><th>가입일</th>
        <c:forEach var="member" items="${list}">
            <tr>
                <td>${member.id}</td>
                <td>${member.email}</td>
                <td>${member.name}</td>
                <td>${member.registerDateTime}</td>
            </tr>
        </c:forEach>
    </tr>
</table>

</body>
</html>
