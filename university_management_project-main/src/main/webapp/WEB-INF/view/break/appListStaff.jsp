<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<style>
.list--table th {
	padding: 3px 12px;
	width: 150px;
	text-align: center;
}

.list--table td {
	padding: 1px 5px;
	text-align: center;
}
</style>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>학사관리</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/user/studentList">학생 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/user/professorList">교수 명단 조회</a></td>
				</tr>
				<tr>
					<td><a href="/user/student">학생 등록</a></td>
				</tr>
				<tr>
					<td><a href="/user/professor">교수 등록</a></td>
				</tr>
				<tr>
					<td><a href="/user/staff">직원 등록</a></td>
				</tr>
				<tr>
					<td><a href="/tuition/bill">등록금 고지서 발송</a></td>
				</tr>
				<tr>
					<td><a href="/break/list/staff" class="selected--menu">휴학 처리</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/period">수강 신청 기간 설정</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>휴학 처리</h1>
		<div class="split--div"></div>

			<c:choose>
				<c:when test="${breakAppList.size() > 0}">
				<div class="d-flex flex-column align-items-center" style="width: 100%">

					<table border="1" class="list--table">
						<thead>
							<tr>
								<th>신청일자</th>
								<th>신청자 학번</th>
								<th>구분</th>
								<th>시작학기</th>
								<th>종료학기</th>
								<th>신청서 확인</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="breakApp" items="${breakAppList}">
								<tr>
									<td>${breakApp.appDate}</td>
									<td>${breakApp.studentId}</td>
									<td>${breakApp.type}휴학</td>
									<td>${breakApp.fromYear}년도&nbsp;${breakApp.fromSemester}학기</td>
									<td>${breakApp.toYear}년도&nbsp;${breakApp.toSemester}학기</td>
									<td><a href="/break/detail/${breakApp.id}">Click</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</c:when>

				<c:otherwise>
					<p class="no--list--p">대기 중인 신청 내역이 없습니다.</p>
				</c:otherwise>
			</c:choose>
	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>

