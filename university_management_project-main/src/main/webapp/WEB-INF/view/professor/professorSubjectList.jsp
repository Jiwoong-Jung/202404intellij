<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/subject.css">

<style>
.sub--filter form div {
	background-color: buttonshadow;
	padding: 13px 10px;
}
</style>

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>수업</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/subject/list/1">전체 강의 조회</a></td>
				</tr>
				<tr>
					<td><a href="/professor/subject" class="selected--menu">내 강의 조회</a></td>
				</tr>
				<c:if test="${principal.userRole.equals(\"professor\") }">
					<tr>
						<td><a href="/evaluation/read"> 내 강의 평가</a></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>내 강의 조회</h1>
		<div class="split--div"></div>
		<div class="sub--filter">
		<form action="/professor/subject" method="post">
			<div>
			<select name="period">
				<c:forEach items="${semesterList}" var="yearSemester">
					<option value="${yearSemester.subYear}year${yearSemester.semester}">${yearSemester.subYear}년도&nbsp;${yearSemester.semester}학기</option>
			</c:forEach>
			</select>
			<!-- 검색 버튼 -->
			<button type="submit">
				<ul class="d-flex justify-content-center" style="margin: 0;">
					<li style="height: 24px; margin-right: 2px;">조회
					<li style="height: 24px;"><span
						class="material-symbols-outlined"
						style="font-size: 18px; padding-top: 4px;">search</span>
				</ul>
			</button>
			</div>
		</form>
		</div>
		<h4>
			<span style="font-weight: 600;">강의 목록</span>
		</h4>
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>학수번호</th>
					<th>강의명</th>
					<th>강의시간</th>
					<th>강의계획서</th>
					<th>학생 목록</th>
				</tr>
			</thead>
			<c:forEach items="${subjectList}" var="subject">
				<tbody>
					<tr>
						<td>${subject.id}</td>
						<td>${subject.name}</td>
						<td>
							<c:choose>
								<c:when test="${subject.startTime < 10}">
									${subject.subDay} 0${subject.startTime}:00-${subject.endTime}:00&nbsp;(${subject.roomId})								
								</c:when>
								<c:otherwise>
									${subject.subDay} ${subject.startTime}:00-${subject.endTime}:00&nbsp;(${subject.roomId})							
								</c:otherwise>
							</c:choose>
						</td>
						<td>									
							<ul class="d-flex justify-content-center sub--plan--view" style="margin: 0;">
								<li style="height: 24px;"><a href="/subject/syllabus/${subject.id}" onclick="window.open(this.href, '_blank', 'width=1000, height=1000'); return false;">조회</a>
								<li style="height: 24px;"><a href="/subject/syllabus/${subject.id}" onclick="window.open(this.href, '_blank', 'width=1000, height=1000'); return false;"><span class="material-symbols-outlined">content_paste_search</span></a>
							</ul>
						</td>
						<td>
							<ul class="d-flex justify-content-center sub--plan--view" style="margin: 0;">
								<li style="height: 24px;"><a href="/professor/subject/${subject.id}">조회</a>
								<li style="height: 24px;"><a href="/professor/subject/${subject.id}"><span class="material-symbols-outlined">content_paste_search</span></a>
							</ul>
						</td>
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