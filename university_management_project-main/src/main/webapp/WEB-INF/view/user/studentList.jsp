<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>

<style>
.sub--list--table th {
	padding: 3px 9px;
	text-align: center;
}

.sub--list--table td {
	padding: 1px 9px;
	text-align: center;
}

.sub--list--name {
	text-align: left !important;
	padding-right: 20px !important;
}

.sub--filter {
	margin-bottom: 50px;
}

.sub--filter form {
	display: flex;
}

.sub--filter form div {
	background-color: buttonshadow;
	padding: 13px 13px 7px 10px;
}

.sub--filter input[type="number"] {
	width: 57px;
	padding-left: 3px;
}

.sub--filter select[name="deptId"] {
	width: 173px;
}

.sub--filter label {
	margin-right: 5px;
}

.sub--filter input, .sub--filter select {
	margin-right: 10px;
	border-radius: 5px;
	border-width: 1px;
}

.sub--filter button {
	background-color: gray;
	padding: 2px 6px;
	border: none;
	border-radius: 5px;
	color: white;
	height: 28px;
}

.sub--plan--view li a:hover {
	color: black;
}
.paging--container {
	display: flex;
	justify-content: center;
}
</style>

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
					<td><a href="/user/studentList" class="selected--menu">학생 명단 조회</a></td>
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
					<td><a href="/break/list/staff">휴학 처리</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/period">수강 신청 기간 설정</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>학생 명단 조회</h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->

		<!-- 필터 및 검색 -->
		<div class="sub--filter">
			<form action="/user/studentList" method="get">
				<div>
					<!-- 개설연도 숫자 -->
					<label for="deptId">학과 번호</label> <input type="text" name="deptId" id="deptId"> <label for="studentId">학번</label> <input type="text" name="studentId" list="studentId">
					<!-- 검색 버튼 -->
					<button type="submit">
						<ul class="d-flex justify-content-center" style="margin: 0;">
							<li style="height: 24px; margin-right: 2px;">조회
							<li style="height: 24px;"><span class="material-symbols-outlined" style="font-size: 18px; padding-top: 4px;">search</span>
						</ul>
					</button>
					<button type="button" onclick="location.href='/user/student/update'" style="margin-left: 10px;">
						<ul>
							<li style="height: 24px;">새학기 적용
						</ul>
					</button>
				</div>
			</form>
		</div>
		<c:choose>
			<c:when test="${!studentList.isEmpty()}">
				<h4>
					<span style="font-weight: 600;">학생 목록</span>
				</h4>
				<table border="1" class="sub--list--table">
					<thead>
						<tr>
							<th>학번</th>
							<th>이름</th>
							<th>생년월일</th>
							<th>성별</th>
							<th>주소</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>학과번호</th>
							<th>학년</th>
							<th>입학일</th>
							<th>졸업일(졸업예정일)</th>
						</tr>
					</thead>

					<tbody>
						<c:forEach var="student" items="${studentList}">
							<tr>
								<td>${student.id}</td>
								<td>${student.name}</td>
								<td>${student.birthDate}</td>
								<td>${student.gender}</td>
								<td>${student.address}</td>
								<td>${student.tel}</td>
								<td>${student.email}</td>
								<td>${student.deptId}</td>
								<td>${student.grade}</td>
								<td>${student.entranceDate}</td>
								<td>${student.graduationDate}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<ul class="page--list">
					<c:forEach var="index" begin="1" end="${listCount}">
						<c:choose>
							<c:when test="${deptId != null && index != page}">
								<li><a href="/user/studentList/${index}?deptId=${deptId}"> ${index}</a> &nbsp;&nbsp;
							</c:when>
							<c:when test="${deptId != null && index == page}">
								<li><a href="/user/studentList/${index}?deptId=${deptId}" class="selected--page"> ${index}</a> &nbsp;&nbsp;
							</c:when>
							<c:when test="${deptId == null && index == page}">
								<li><a href="/user/studentList/${index}" class="selected--page"> ${index}</a> &nbsp;&nbsp;
							</c:when>
							<c:otherwise>
								<li><a href="/user/studentList/${index}"> ${index}</a> &nbsp;&nbsp;
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
			</c:when>
			<c:otherwise>
				<p class="no--list--p">검색 결과가 없습니다.</p>
			</c:otherwise>
		</c:choose>
	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>

