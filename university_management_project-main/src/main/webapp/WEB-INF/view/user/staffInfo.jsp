<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/myInfo.css">

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>MY</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/info/staff" class="selected--menu">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/password">비밀번호 변경</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>내 정보 조회</h1>
		<div class="split--div"></div>
			<table border="1" class="input--table" >
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
				<tr>
					<th>ID</th>
					<td>${staff.id}</td>
					<th>입사 날짜</th>
					<td>${staff.hireDate}</td>
				</tr>
			</table>
			<table border="1" class="input--table" >
			<colgroup>
				<col class="col1">
				<col class="col2">
				<col class="col3">
				<col class="col4">
			</colgroup>
				<tr>
					<th>성명</th>
					<td>${staff.name}</td>
					<th>생년월일</th>
					<td>${staff.birthDate}</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>${staff.gender}</td>
					<th>주소</th>
					<td>${staff.address}</td>
				</tr>
				<tr>
					<th>연락처</th>
					<td>${staff.tel}</td>
					<th>email</th>
					<td>${staff.email}</td>
				</tr>
			</table>
			<button type="button" onclick="location.href='/update'" class="btn btn-dark update--button">수정하기</button>
	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>