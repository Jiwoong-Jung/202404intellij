<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" href="/css/student.css">

<style>
.list--table td {
	text-align: center;
}
</style>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start"
	style="min-width: 100em;">
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
					<td><a href="/info/student">내 정보 조회</a></td>
				</tr>
				<tr>
					<td><a href="/password">비밀번호 변경</a></td>
				</tr>
				<tr>
					<td><a href="/break/application">휴학 신청</a></td>
				</tr>
				<tr>
					<td><a href="/break/list" class="selected--menu">휴학 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/list">등록금 내역 조회</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/payment">등록금 납부 고지서</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>휴학 내역 조회</h1>
		<div class="split--div"></div>

			<c:choose>
				<c:when test="${breakAppList.size() > 0}">
					<table border="1" class="list--table">
						<thead>
							<tr>
								<th>신청일자</th>
								<th>구분</th>
								<th>시작학기</th>
								<th>종료학기</th>
								<th>신청서 확인</th>
								<th>상태</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="breakApp" items="${breakAppList}">
								<tr>
									<td>${breakApp.appDate}</td>
									<td>${breakApp.type}휴학</td>
									<td>${breakApp.fromYear}년도&nbsp;${breakApp.fromSemester}학기</td>
									<td>${breakApp.toYear}년도&nbsp;${breakApp.toSemester}학기</td>
									<td><a href="/break/detail/${breakApp.id}">Click</a></td>
									<td><c:choose>
											<c:when test="${breakApp.status.equals(\"처리중\")}">
												<span style="color: #767676; font-weight: 600">처리중</span>
											</c:when>
											<c:when test="${breakApp.status.equals(\"승인\")}">
												<span style="color: blue; font-weight: 600">승인</span>
											</c:when>
											<c:otherwise>
												<span style="color: red; font-weight: 600">반려</span>
											</c:otherwise>
										</c:choose></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
			</c:when>
				<c:otherwise>
					<p class="no--list--p">휴학 신청 내역이 없습니다.</p>
				</c:otherwise>
			</c:choose>
	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>

