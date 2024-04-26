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

section {
	padding: 10px 100px;
}

input[type="text"]{
	font-size: 16px;
	padding: 5px;
}

textarea {
	font-size: 16px;
	padding: 5px;
	resize: none;
}

.submit--button {
	margin-top: 20px;
	margin-left: 200px;
	padding: 10px 15px;
	border: none;
	border-radius: 10px;
	color: white;
	background-color: #142845;
	cursor: pointer;
}
</style>
</head>
<body>
	<header>
		<div class="header--top"></div>
	</header>
	<section>
		<h2>강의 계획서 수정</h2>
		<br> 
		<form action="/professor/syllabus/update/${syllabus.subjectId}" method="post">
			<input type="hidden" name="_method" value="put"/>
			<label>강의 개요</label> <br> 
			<textarea rows="5" cols="50" name="overview">${syllabus.overview}</textarea>
			<br> <label>수업 목표</label> <br> 
			<textarea rows="5" cols="50" name="objective">${syllabus.objective}</textarea>
			<br> <label>교재</label> <br> <input type="text" name="textbook" value="${syllabus.textbook}"> <br>  
			<label>주별 계획</label> <br> 
			<textarea rows="10" cols="50" name="program">${syllabus.program}</textarea>
			<br>
			<button type="submit" class="submit--button">제출</button>
		</form>
	</section>

</body>
</html>