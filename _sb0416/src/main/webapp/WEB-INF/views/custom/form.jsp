<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>커스텀 태그 연습</title>
</head>
<body>
<p>커스텀 태그 연습</p>
<form:form modelAttribute="formCommand">
    <p>
        <label for="loginType">로그인 타입(form:options)</label>
        <form:select path="loginType">
            <option value="">--- 선택하세요 ---</option>
            <form:options items="${loginTypes}" />
        </form:select>
    </p>
    <p>
        <label for="loginType">로그인 타입(form:select)</label>
<%--        <form:select path="loginType" items="${loginTypes}" />--%>
<%--        <select name="loginType">--%>
<%--            <c:forEach var="logintype" items="${loginTypes}">--%>
<%--                <option value="${logintype}">${logintype}</option>--%>
<%--            </c:forEach>--%>
<%--        </select>--%>
    </p>
    <p>
        <label>선호 OS</label>
<%--        <form:checkboxes items="${favoriteOsNames}" path="favoriteOs" />--%>
    </p>
    <p>
        <label>선호 OS</label>
        <form:checkboxes items="${favoriteOsCodes}" path="favoriteOs"
                         itemValue="code" itemLabel="label" />
    </p>


    <input type="submit" value="완료">
</form:form>

</body>
</html>