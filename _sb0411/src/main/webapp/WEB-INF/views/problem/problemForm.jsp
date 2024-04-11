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
            1. 당신의 역할은 무엇입니까?<br/>

            <label><input type="radio"
                          name="dataList[0]" value="서버">
                서버</label>

            <label><input type="radio"
                          name="dataList[0]" value="프론트">
                프론트</label>

            <label><input type="radio"
                          name="dataList[0]" value="풀스택">
                풀스택</label>

            <label><input type="radio"
                          name="dataList[0]" value="백엔드">
                백엔드</label>
        </p>

        <input type="submit" value="확인">
    </form>
</body>
</html>
