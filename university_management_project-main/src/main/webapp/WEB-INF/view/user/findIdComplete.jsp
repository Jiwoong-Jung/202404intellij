<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style type="text/css">
@import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap');

* {
	margin: 0 auto;
	padding: 0 auto;
	font-family: 'Noto Sans KR', sans-serif;
}

.header--top {
	width: 100%;
	height: 40px;
	background-color: #031734;
}

.section--header {
	text-align: center;
}

.search--table {
	width: 400px;
}

.search--table td {
	padding: 4px;
	text-align: left;
}

.col1 {
	width: 20%;
}

.col2 {
	width: 80%;
}

.submit--button {
	margin-top: 20px;
	margin-left: 200px;
}

.section--content{
	margin: 20px 50px;
	text-align: center;
}
</style>
</head>

<body>
	<header>
		<div class="header--top"></div>
	</header>
	<section>
		<div class="section--header">
			<h2>아이디 찾기</h2>
			<br>
		</div>
		<div class="section--content">
			${name}님의 아이디는<br> 
			<span style="font-weight: bold;">${id}</span>입니다.
		</div>
	</section>

</body>
</html>