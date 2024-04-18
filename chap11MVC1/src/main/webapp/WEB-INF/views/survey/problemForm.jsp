<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>테스트</title>
</head>
<body>
    <h2>테스트</h2>

    <form method="post">
        <input type="hidden" name="id" value="999">
        <c:forEach var="q" items="${questions}" varStatus="sta">
            <p>
                ${sta.index+1}. ${q.title}<br/>
                <c:if test="${q.choice}">
                    <c:forEach var="opt" items="${q.options}">
                    <label>
                        <input type="radio" name="dataList[${sta.index}]" value="${opt}">${opt}
                    </label>
                    </c:forEach>
                </c:if>
                <c:if test="${!q.choice}">
                    <input type="text" name="dataList[${sta.index}]">
                </c:if>
            </p>
        </c:forEach>
        <p>
            <label>응답자 이름:<br>
                <input type="text" name="name">
            </label>
        </p>
        <p>
            <label>응답자 나이:<br>
                <input type="text" name="age">
            </label>
        </p>
        <input type="submit" value="확인">
    </form>
</body>
</html>
