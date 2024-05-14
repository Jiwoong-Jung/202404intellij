<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>피자 주문</title>
    <link rel="stylesheet" href="/css/sol-1.css">
</head>
<body>
<div id="container">
    <h1>피자 주문</h1>
    <form:form>
        <fieldset>
            <legend>사이즈</legend>
            <p>Large - 24000 원 </p>
        </fieldset>
        <fieldset>
            <legend>추가 주문 </legend>
            <label><input type="checkbox" name="pickle" class="checkbx" value="800">피클(800원)</label>
            <label><input type="checkbox" name="chilly" class="checkbx" value="300">칠리 소스(300원)</label>
            <label><input type="checkbox" name="deeping" class="checkbx" value="200">디핑 소스(200원)</label>
            <label><input type="checkbox" name="stick" class="checkbx" value="4800">치즈스틱(4개, 4800원)</label>
            <label><input type="checkbox" name="salad" class="checkbx" value="2400">콘 샐러드(2400원)</label>
        </fieldset>
        <fieldset>
            <legend>합계</legend>
            <input type="text" id="total" name="total" class="price" readonly>
        </fieldset>
        <input type="submit" />
    </form:form>
</div>

<script src="js/sol-1.js"></script>
</body>
</html>