<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>주문목록</title>
    <link rel="stylesheet" type="text/css" href="/css/visitor.css">
</head>
<body>
<form action="complete" method="post">
<table border="1">
    <tr>
        <th>ID</th><th>total</th><th>pickle</th><th>chilly</th><th>deeping</th>
        <th>stick</th><th>salad</th><th>제조</th>
    </tr>
        <c:forEach var="pizza" items="${list}">
            <tr>
                <td>${pizza.id}</td>
                <td>${pizza.total}</td>
                <td>${pizza.pickle}</td>
                <td>${pizza.chilly}</td>
                <td>${pizza.deeping}</td>
                <td>${pizza.stick}</td>
                <td>${pizza.salad}</td>
                <td><button type="button" onclick="location.href='complete?id=${pizza.id}' ">완료</button>
                </td>
            </tr>
        </c:forEach>

</table>
</form>
</body>
</html>
