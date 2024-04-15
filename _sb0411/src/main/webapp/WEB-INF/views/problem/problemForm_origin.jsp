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
        <c:forEach var="q" items="${questions}" varStatus="sta">
            <p>
                ${sta.index+1}. ${q.title}<br/>
                <c:forEach var="opt" items="${q.options}">
                    <label>
                        <input type="radio" name="dataList[${sta.index}]" value="${opt}">${opt}
                    </label>

                </c:forEach>
                <c:if test="${q.choice}">
                    ${q.choice}<br/>
                </c:if>
                <c:if test="${!q.choice}">
                    없다<br/>
                </c:if>
            </p>
        </c:forEach>

        <input type="submit" value="확인">
    </form>
</body>
</html>
