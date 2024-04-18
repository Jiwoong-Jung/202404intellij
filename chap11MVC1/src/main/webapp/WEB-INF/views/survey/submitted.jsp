<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>응답 내용</title>
</head>
<body>
    <p>응답 내용:</p>
    <ul>
        <c:forEach var="data" items="${answerEntity.dataList}" varStatus="sta">
            <li>${sta.index+1}번 응답: ${data}</li>
        </c:forEach>
    </ul>
    <p>응답자 이름: ${answerEntity.name}</p>
    <p>응답자 나이: ${answerEntity.age}</p>
</body>
</html>
