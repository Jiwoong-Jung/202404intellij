<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/subject.css">

<style>
.form--table tr td:first-of-type {
	width: 80px;
}

.form--table tr:first-of-type td:last-of-type {
	padding-left: 15px;
}

.form--table label {
	margin: 0;
}

.form--table tr td {
	padding-bottom: 5px;
}

.form--table tr:last-of-type td {
	padding-top: 15px;
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
		<h1>학생 성적 기입</h1>
		<div class="split--div"></div>
		<table border="1" class="sub--list--table">
			<thead>
				<tr>
					<th>학생 번호</th>
					<th>이름</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${student.id}</td>
					<td>${student.name}</td>
				</tr>
			</tbody>
		</table>
		<br>
		<form action="/professor/subject/${subjectId}/${student.id}" method="post">
		<input type="hidden" name="_method" value="put"/>
			<table class="form--table">
				<tr>
					<td><label>결석</label></td>
					<td><input type="number" name="absent" id="absent"></td>
					<td><span style="color:#888">※ 결석 5회 이상시 F학점입니다.</span></td>
				</tr>
				<tr>
					<td><label>지각</label></td>
					<td><input type="number" name="lateness" id="lateness"></td>
				</tr>
				<tr>
					<td><label>과제점수</label></td>
					<td><input type="number" name="homework" id="homework"></td>
				</tr>
				<tr>
					<td><label>중간시험</label></td>
					<td><input type="number" name="midExam" id="midExam"></td>
				</tr>
				<tr>
					<td><label>기말시험</label></td>
					<td><input type="number" name="finalExam" id="finalExam"></td>
				</tr>
				<tr>
					<td><label>환산점수</label></td>
					<td><input type="number" name="convertedMark" id="convertedMark"></td>
				</tr>
				<tr>
					<td><label>등급</label></td>
					<td><select name="grade">
							<option value="A+">A+</option>
							<option value="A0">A0</option>
							<option value="B+">B+</option>
							<option value="B0">B0</option>
							<option value="C+">C+</option>
							<option value="C0">C0</option>
							<option value="D+">D+</option>
							<option value="D0">D0</option>
							<option value="F">F</option>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><button type="submit" class="btn btn-dark update--button">제출하기</button> </td>
				</tr>

			</table>
		</form>

	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>
