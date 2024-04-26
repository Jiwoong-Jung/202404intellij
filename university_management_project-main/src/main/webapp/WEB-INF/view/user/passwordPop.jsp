<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강의계획서</title>
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

.section--content {
	margin: 20px 50px;
	text-align: center;
}

a {
	text-decoration: none;
	color: black;
	font-weight: 600;
}

button{
	padding: 10px 15px;
	border: none;
	border-radius: 10px;
	color: white;
	background-color: #142845;
	cursor: pointer;
}
</style>
<script language="JavaScript" type="text/JavaScript">
	function linkToOpener(url) {
		window.opener.location.href="/password";
		window.close();
	}
</script>
</head>

<body>
	<header>
		<div class="header--top"></div>
	</header>
	<section>
		<div class="section--header">
			<h2>안내</h2>
		</div>
		<div class="section--content">
			현재 비밀번호가 초기 설정되어있는 비밀번호입니다.<br> 
			비밀번호를 다시 설정해주세요.<br><br>
			<button onclick="linkToOpener()">비밀번호 변경하러 가기</button>
		</div>
	</section>

</body>
</html>