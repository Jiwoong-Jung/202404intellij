<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원 조회</title>
    <link rel="stylesheet" href="/css/sol-1.css">
</head>
<body>
    <form:form modelAttribute="cmd">
    <p>
        <label>from: <input type="datetime-local" id="from" name="from"  value="2024-04-28T10:00" /></label>
        <form:errors path="from" />
        ~
        <label>to:<input type="datetime-local" id="to" name="to" value="2024-04-30T17:00" /></label>
        <form:errors path="to" />
        <input type="submit" value="조회">
    </p>
    </form:form>
    
    <c:if test="${! empty members}">
    <table>
        <tr>
            <th>아이디</th><th>이메일</th>
            <th>이름</th><th>가입일</th>
        </tr>
        <c:forEach var="mem" items="${members}">
        <tr>
            <td>${mem.id}</td>
            <td><a href="<c:url value="/members/${mem.id}"/>">
                ${mem.email}</a></td>
            <td>${mem.name}</td>
            <td><tf:formatDateTime value="${mem.registerDateTime }" 
                                   pattern="yyyy-MM-dd" /></td>
        </tr>
        </c:forEach>
    </table>
    </c:if>
</body>
</html>
