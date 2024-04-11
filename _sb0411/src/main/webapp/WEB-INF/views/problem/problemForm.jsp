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

        <p>
            ${question.title}<br/>
            <c:forEach var="opt" items="${question.options}">
                <label>
                    <input type="radio" name="dataList[0]" value="${opt}">${opt}
                </label>

            </c:forEach>
        </p>

        <input type="submit" value="확인">
    </form>
</body>
</html>
