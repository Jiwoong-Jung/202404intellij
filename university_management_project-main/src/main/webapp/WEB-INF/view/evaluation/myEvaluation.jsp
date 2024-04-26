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
				<c:if test="${principal.userRole.equals(\"professor\") }">
					<tr>
						<td><a href="/professor/subject">내 강의 조회</a></td>
					</tr>
				</c:if>
				<c:if test="${principal.userRole.equals(\"professor\") }">
					<tr>
						<td><a href="/evaluation/read" class="selected--menu">내 강의 평가</a></td>
					</tr>
				</c:if>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>내 강의 평가</h1>
		<div class="split--div"></div>

		<c:choose>
			<c:when test="${subjectName.isEmpty() == false}">
				<div class="sub--filter">
					<!-- 강의평가 과목 조회 -->
					<form action="/evaluation/read" method="post">
						<div>
							<select name="subjectId">
								<c:forEach var="dto" items="${subjectName}">
									<option value="${dto.name}">${dto.name}</option>
								</c:forEach>
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
				<table border="1" class="sub--list--table">
					<thead>
						<tr>
							<th>과목 이름</th>
							<th>총 평가 점수</th>
							<th>건의 사항</th>
						</tr>
					</thead>
					<c:forEach var="eval" items="${eval}">
						<tr>
							<td>${eval.name}</td>
							<td>${eval.answerSum()}</td>
							<td>${eval.improvements}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<p class="no--list--p">조회할 강의 평가가 존재하지 않습니다.</p>
			</c:otherwise>
		</c:choose>

	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>

