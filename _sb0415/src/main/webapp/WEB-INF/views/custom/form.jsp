<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>로그인</title>
</head>
<body>
<h1>커스텀 태그 연습123</h1>
    <form:form modelAttribute="formCommand">
<%--        <p>--%>
<%--            <label for="loginType">로그인 타입(form:select)</label>--%>
<%--            <form:select path="loginType" items="${loginTypes}" />--%>
<%--        </p>--%>
        <p>
            <label for="loginType">로그인 타입(form:options)</label>
            <form:select path="loginType">
                <option value="">--- 선택하세요 ---</option>
                <form:options items="${loginTypes}" />
            </form:select>
        </p>
        <p>
            <label>선호 OS</label>
            <form:checkboxes items="${favoriteOsNames}" path="favoriteOs" />
        </p>

        <p>
            <label>선호 OS</label>
            <form:checkboxes items="${favoriteOsCodes}" path="favoriteOs"
                             itemValue="code" itemLabel="label" />
        </p>
        <hr />
        <form:select path="jobCode">
            <option value="">--- 선택하세요 ---</option>
            <form:options items="${jobCodes}" itemLabel="label" itemValue="code" />
        </form:select>
        <input type="submit" value="가입 완료">
    </form:form>


</body>
</html>