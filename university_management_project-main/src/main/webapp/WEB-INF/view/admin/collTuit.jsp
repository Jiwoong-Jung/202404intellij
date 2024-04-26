<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/admin.css">
<style>

</style>
<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>등록</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/admin/college">단과대학</a></td>
				</tr>
				<tr>
					<td><a href="/admin/department">학과</a></td>
				</tr>
				<tr>
					<td><a href="/admin/room">강의실</a></td>
				</tr>
				<tr>
					<td><a href="/admin/subject">강의</a></td>
				</tr>
				<tr>
					<td><a href="/admin/tuition" class="selected--menu">단대별 등록금</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>단대별 등록금</h1>
		<div class="split--div"></div>
		<div class="select--button">
			<a href="/admin/tuition?crud=insert" class="button">등록</a> 
			<a href="/admin/tuition?crud=update" class="button">수정</a> 
			<a href="/admin/tuition?crud=delete" class="button">삭제</a>
		</div>


		<!-- 등록금 입력 -->
		<c:if test="${crud.equals(\"insert\")}">
			<form action="/admin/tuition" method="post" class="form--container">
				<div class="insert--form">
					<ul class="d-flex" style="margin: 0;">
						<li style="height: 24px; margin-right: 2px;"><span class="material-symbols-outlined">school</span>
						<li style="height: 24px;"><span class="insert">등록하기</span>
					</ul>
						<select name="collegeId" class="input--box">
							<c:forEach var="college" items="${collegeList}">
								<option value="${college.id}">${college.name}</option>
							</c:forEach>
						</select>
				<input type="text" id="name" class="input--box" name="amount" placeholder="등록금을 입력해주세요"> 
					<input type="submit" value="입력">
				</div>
			</form>
			<table class="table--container">
				<tr class="first--tr">
					<td>ID</td>
					<td>단과대</td>
					<td>금액</td>
				</tr>
				<c:forEach var="collTuit" items="${collTuitList}">
					<tr>
						<td>${collTuit.collegeId}</td>
						<td>${collTuit.name}</td>
						<td>${collTuit.amountFormat()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>


		<!-- 등록금 수정 -->
		<c:if test="${crud.equals(\"update\")}">
			<form action="/admin/tuitionUpdate" method="post" class="insert--form">
			<input type="hidden" name="_method" value="put" />
					<ul class="d-flex" style="margin: 0;">
						<li style="height: 24px; margin-right: 2px;"><span class="material-symbols-outlined">school</span>
						<li style="height: 24px;"><span class="insert">수정하기</span>
					</ul>
					<select name="collegeId" class="input--box">
						<c:forEach var="college" items="${collegeList}">
							<option value="${college.id}">${college.name}</option>
						</c:forEach>
					</select> 
				<input type="text" name="amount" class="input--box" placeholder="등록금을 입력하세요"> 
				<input type="submit" value="수정" class="button">
			</form>
			<table class="table--container">
				<tr class="first--tr">
					<td>ID</td>
					<td>단과대</td>
					<td>금액</td>
				</tr>
				<c:forEach var="collTuit" items="${collTuitList}">
					<tr>
						<td>${collTuit.collegeId}</td>
						<td>${collTuit.name}</td>
						<td>${collTuit.amountFormat()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>


		<!-- 등록금 삭제 -->
		<c:if test="${crud.equals(\"delete\")}">
			<span class="delete">등록금을 삭제할 단과대학을 클릭해주세요</span>
			<table class="table--container">
				<tr class="first--tr">
					<td>ID</td>
					<td>단과대</td>
					<td>금액</td>
				</tr>
				<c:forEach var="collTuit" items="${collTuitList}">
					<tr>
						<td>${collTuit.collegeId}</td>
						<td><a href="/admin/tuitionDelete?collegeId=${collTuit.collegeId}">${collTuit.name}</a></td>
						<td>${collTuit.amountFormat()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>


		<!-- 등록금 조회 -->
		<c:if test="${crud.equals(\"select\")}">
			<div class="form--container">
				<table class="table--container">
				<tr class="first--tr">
					<td>ID</td>
					<td>단과대</td>
					<td>금액</td>
				</tr>
				<c:forEach var="collTuit" items="${collTuitList}">
					<tr>
						<td>${collTuit.collegeId}</td>
						<td>${collTuit.name}</td>
						<td>${collTuit.amountFormat()}</td>
					</tr>
				</c:forEach>
			</table>
			</div>
		</c:if>
	</main>

	<%@ include file="/WEB-INF/view/layout/footer.jsp"%>
</div>
</body>
</html>