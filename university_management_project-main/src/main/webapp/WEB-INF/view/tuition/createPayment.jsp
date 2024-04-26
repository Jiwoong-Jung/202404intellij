<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<td><a href="/tuition/bill" class="selected--menu">등록금 고지서 발송</a></td>
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
		<h1>등록금 고지서 발송</h1>
		<div class="split--div"></div>
		<a href="/tuition/create"><button type="submit" class="btn btn-primary create--tui">등록금 고지서 발송</button></a>
		<c:if test="${insertCount != null}">
			<%
			out.println(
					"<script>alert('" + request.getAttribute("insertCount") + "개의 등록금 고지서가 생성되었습니다.'); history.back(); </script>");
			%>
		</c:if>
	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>

