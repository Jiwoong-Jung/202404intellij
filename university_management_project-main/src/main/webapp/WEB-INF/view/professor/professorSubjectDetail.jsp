<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style>
form {
	margin-left: 30px;
}

.input--table th, td {
	padding: 5px 10px;
}


</style>

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
					<td><a href="/user/student">학생 ID 생성</a></td>
				</tr>
				<tr>
					<td><a href="/user/professor">교수 ID 생성</a></td>
				</tr>
				<tr>
					<td><a href="/user/staff">직원 ID 생성</a></td>
				</tr>
				<tr>
					<td><a href="/update" class="selected--menu">개인 정보 수정</a></td>
				</tr>
				<tr>
					<td><a href="/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/professor/subject">교수 자기 강의 조회</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>과목 상세 조회</h1>
		<div class="split--div"></div>
		
		<table border="1">
			<thead>
				<tr>
					<th>과목id</th>
					<td>10000</td>
					<th></th>
					<th>강의계획서</th>
					<th>학생 성적 기입</th>
				</tr>
			</thead>
			<c:forEach items="${subjectList}" var="subject">
			<tbody>
				<tr>
					<td>${subject.id}</td>
					<td>${subject.name}</td>
					<td>${subject.time}</td>
					<td><a href="#">강의 계획서 보기</a></td>
					<td><a href="#">학생 리스트 보기</a></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>

	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>