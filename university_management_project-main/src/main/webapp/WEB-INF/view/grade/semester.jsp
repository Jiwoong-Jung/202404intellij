<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/css/subject.css">

<style>
.button {
	margin-left: 20px;
}

.sub--filter form div {
	background-color: buttonshadow;
	padding: 13px 10px;
}

.sub--list--table th {
	padding: 1px 25px;
}
</style>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- 학기별 성적 조회 -->

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>성적</h2>
		</div>
		<!-- 메뉴 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/grade/thisSemester">금학기 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/grade/semester" class="selected--menu">학기별 성적 조회</a></td>
				</tr>
				<tr>
					<td><a href="/grade/total">누계 성적</a></td>
				</tr>
			</table>
		</div>
	</div>
	<!-- 메인 div -->
	<main>
		<h1>학기별 성적 조회</h1>
		<div class="split--div"></div>
		<c:choose>
			<%-- 수강연도 조회해서 검사 --%>
			<c:when test="${gradeList.isEmpty() == false}">
				<div class="sub--filter">
					<%-- 타입 받아서 조회 --%>
					<form action="/grade/read" method="post">
						<div>
						<select name="subYear">
							<c:forEach var="grade" items="${yearList}">
								<option value="${grade.subYear}">${grade.subYear}년</option>
							</c:forEach>
						</select> <select name="sesmeter">
							<c:forEach var="grade" items="${semesterList}">
								<option value="${grade.semester}">${grade.semester}학기</option>
							</c:forEach>
						</select> <select name="type">
							<option value="전체">전체</option>
							<option value="전공">전공</option>
							<option value="교양">교양</option>
						</select>
						<!-- 검색 버튼 -->
						<button type="submit">
							<ul class="d-flex justify-content-center" style="margin: 0;">
								<li style="height: 24px; margin-right: 2px;">조회
								<li style="height: 24px;"><span class="material-symbols-outlined" style="font-size: 18px; padding-top: 4px;">search</span>
							</ul>
						</button>
						</div>
					</form>
				</div>
				<h4 style="font-weight: 600">과목별 성적</h4>
				<table border="1" class="sub--list--table">
					<thead>
						<tr>
							<th>연도</th>
							<th>학기</th>
							<th>과목번호</th>
							<th>과목명</th>
							<th>강의구분</th>
							<th>학점</th>
						</tr>
					</thead>
					<tbody>
						<%-- 조회한 값 --%>
						<c:forEach var="grade" items="${gradeList}">
							<tr>
								<td>${grade.subYear}년</td>
								<td>${grade.semester}학기</td>
								<td>${grade.subjectId}</td>
								<td>${grade.name}</td>
								<td>${grade.type}</td>
								<td>${grade.grade}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</c:when>
			<c:otherwise>
				<p class="no--list--p">강의 신청 및 수강 이력 확인 바랍니다.</p>
			</c:otherwise>
		</c:choose>
		<br> <br>


	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>

