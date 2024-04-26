<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>

<style>
li {
	list-style: none;
}

.button--row {
	margin-top: 30px;
	text-align: center;
	width: 100%;
}

.title--row {
	text-align: center;
	width: 100%;
	margin: 20px 0px;
}

.title--row h1 {
	font-weight: 600;
}

hr {
	margin-bottom: 30px;
}

.radio--check li:first-of-type {
	font-size: 17px;
	margin-bottom: 10px;
}

.etc--row li:first-of-type {
	margin-bottom: 10px;
}

.etc--row span {
	font-weight: 600;
	font-size: 20px;
}
</style>
<body>
	<c:if test="${type == 1}">
		<script>
			window.close();
		</script>
	</c:if>

	<main>
		<div class="title--row">
			<h1>강의 평가</h1>
		</div>
		<hr>
		<form action="/evaluation/write/${subjectId}" method="post">
			<ul class="radio--check">
				<li>1.&nbsp;${dto.question1}</li>
				<li>&nbsp;<input type="radio" name="answer1" value="5" id="a11"> <label for="a11"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="4" id="a12"> <label for="a12"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="3" id="a13"> <label for="a13"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="2" id="a14"> <label for="a14"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer1" value="1" id="a15"> <label for="a15"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>2.&nbsp;${dto.question2}</li>
				<li>&nbsp;<input type="radio" name="answer2" value="5" id="a21"> <label for="a21"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="4" id="a22"> <label for="a22"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="3" id="a23"> <label for="a23"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="2" id="a24"> <label for="a24"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer2" value="1" id="a25"> <label for="a25"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>3.&nbsp;${dto.question3}</li>
				<li>&nbsp;<input type="radio" name="answer3" value="5" id="a31"> <label for="a31"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="4" id="a32"> <label for="a32"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="3" id="a33"> <label for="a33"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="2" id="a34"> <label for="a34"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer3" value="1" id="a35"> <label for="a35"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>4.&nbsp;${dto.question4}</li>
				<li>&nbsp;<input type="radio" name="answer4" value="5" id="a41"> <label for="a41"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="4" id="a42"> <label for="a42"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="3" id="a43"> <label for="a43"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="2" id="a44"> <label for="a44"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer4" value="1" id="a45"> <label for="a45"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>5.&nbsp;${dto.question5}</li>
				<li>&nbsp;<input type="radio" name="answer5" value="5" id="a51"> <label for="a51"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="4" id="a52"> <label for="a52"> 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="3" id="a53"> <label for="a53"> 보통</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="2" id="a54"> <label for="a54"> 그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer5" value="1" id="a55"> <label for="a55"> 전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>6.&nbsp;${dto.question6}</li>
				<li>&nbsp;<input type="radio" name="answer6" value="5" id="a61"> <label for="a61"> 매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="4" id="a62"> <label for="a62">그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="3" id="a63"> <label for="a63">보통</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="2" id="a64"> <label for="a64">그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer6" value="1" id="a65"> <label for="a65">전혀 그렇지 않다</label></li>
			</ul>
			<ul class="radio--check">
				<li>7.&nbsp;${dto.question7}</li>
				<li><input type="radio" name="answer7" value="5" id="a71"> <label for="a71">매우 그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="4" id="a72"> <label for="a72">그렇다</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="3" id="a73"> <label for="a73">보통</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="2" id="a74"> <label for="a74">그렇지 않다</label></li>
				<li>&nbsp;<input type="radio" name="answer7" value="1" id="a75"> <label for="a75">전혀 그렇지 않다</label></li>
			</ul> 
			<ul class="etc--row">
				<li><span>${dto.sugContent}</span></li>
				<li><textarea cols="80" rows="5" name="improvements"> </textarea></li>
			</ul>

			<div class="button--row">
				<button type="submit" class="btn btn-dark update--button">제출하기</button>
			</div>
		</form>
	</main>
</body>
</html>