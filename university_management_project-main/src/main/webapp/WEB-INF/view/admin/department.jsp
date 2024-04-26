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
					<td><a href="/admin/department" class="selected--menu">학과</a></td>
				</tr>
				<tr>
					<td><a href="/admin/room">강의실</a></td>
				</tr>
				<tr>
					<td><a href="/admin/subject">강의</a></td>
				</tr>
				<tr>
					<td><a href="/admin/tuition">단대별 등록금</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>학과</h1>
		<div class="split--div"></div>
		<div class="select--button">
			<a href="/admin/department?crud=insert" class="button">등록</a>
			<a href="/admin/department?crud=update" class="button">수정</a> 
			<a href="/admin/department?crud=delete" class="button">삭제</a>
		</div>
			
			<!-- 학과 입력 -->
			<c:if test="${crud.equals(\"insert\")}">
			<div class="container">
				<form action="/admin/department" method="post" class="form--container">
					<ul class="d-flex" style="margin: 0;">
						<li style="height: 24px; margin-right: 2px;"><span class="material-symbols-outlined">school</span>
						<li style="height: 24px;"><span class="insert">등록하기</span>
					</ul>
						<input type="text" class="input--box" name="name" placeholder="학과를 입력해주세요"> 
							<select name="collegeId" class="input--box">
								<c:forEach var="college" items="${collegeList}">
									<option value="${college.id}">${college.name}</option>
								</c:forEach>
							</select> 
							<input type="submit" class="button" value="입력">
				</form>
				<div class="total--container">
					<table class="table--container">
						<tr class="first--tr">
							<td>ID</td>
							<td>학과명</td>
							<td>단과대ID</td>
						</tr>
						<c:forEach var="department" items="${departmentList}">
							<tr>
								<td>${department.id}</td>
								<td>${department.name}</td>
								<td>${department.collegeId}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			</c:if>


			<!-- 학과 수정  -->
			<c:if test="${crud.equals(\"update\")}">
			<div class="container">
				<form action="/admin/department" method="post" id="form--container">
					 <input type="hidden" name="_method" value="put"/>
					<ul class="d-flex" style="margin: 0;">
						<li style="height: 24px; margin-right: 2px;"><span class="material-symbols-outlined">school</span>
						<li style="height: 24px;"><span class="insert">수정하기</span>
					</ul>
								<select name="id" class="input--box">
									<c:forEach var="department" items="${departmentList}">
										<option value="${department.id}">${department.name}</option>
									</c:forEach>
								</select>
							<input type="text" class="input--box" name="name" placeholder="변경할 학과명을 입력하세요"> 
							<input type="submit" value="수정" class="button">
				</form>

				<table class="table--container">
					<tr class="first--tr">
						<td>ID</td>
						<td>학과명</td>
						<td>단과대ID</td>
					</tr>
					<c:forEach var="department" items="${departmentList}">
						<tr>
							<td>${department.id}</td>
							<td>${department.name}</td>
							<td>${department.collegeId}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			</c:if>


			<!-- 학과 삭제 -->
			<c:if test="${crud.equals(\"delete\")}">
			<span class="delete">삭제할 학과 이름을 클릭해주세요</span>
			<div class="total--container">
				<table class="table--container">
					<tr class="first--tr">
						<td>ID</td>
						<td>학과명</td>
						<td>단과대ID</td>
					</tr>
					<c:forEach var="department" items="${departmentList}">
						<tr>
							<td>${department.id}</td>
							<td><a href="/admin/departmentDelete?id=${department.id}">${department.name}</a></td>
							<td>${department.collegeId}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
			</c:if>

			
			<!-- 학과 조회 -->
			<c:if test="${crud.equals(\"select\")}">
				<div class="total--container">
				<table class="table--container">
					<tr class="first--tr">
						<td>ID</td>
						<td>학과명</td>
						<td>단과대ID</td>
					</tr>
					<c:forEach var="department" items="${departmentList}">
						<tr>
							<td>${department.id}</td>
							<td>${department.name}</td>
							<td>${department.collegeId}</td>
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