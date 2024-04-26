<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="/css/subject.css">

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">
	<!-- 세부 메뉴 div-->
	<div class="sub--menu">
		<div class="sub--menu--top">
			<h2>수강신청</h2>
		</div>
		<!-- 메뉴 -->
		<!-- 선택된 메뉴에 class="selected--menu" 추가해주세요 -->
		<div class="sub--menu--mid">
			<table class="sub--menu--table" border="1">
				<tr>
					<td><a href="/sugang/subjectList/1" class="selected--menu">강의 시간표 조회</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/pre/1">예비 수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/preAppList?type=1">수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/list">수강 신청 내역 조회</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>강의 시간표 조회</h1>
		<div class="split--div"></div>
		<!-- 필터 및 검색 -->
		<div class="sub--filter">
			<form action="/sugang/subjectList/search" method="get">
				<div>
					<!-- 강의구분 콤보박스 -->
					<label for="type">강의구분</label> 
					<select name="type" id="type">
						<option value="전체">전체</option>
						<option value="전공">전공</option>
						<option value="교양">교양</option>
					</select>
					<!-- 대상학과 콤보박스 -->
					<label for="deptId">개설학과</label> 
					<select name="deptId" id="deptId">
						<option value="-1">전체</option>
						<c:forEach var="dept" items="${deptList}">
							<option value="${dept.id}">${dept.name}</option>
						</c:forEach>
					</select>
					<!-- 강의 검색 -->
					<label for="subName">강의명</label> 
					<input type="text" name="name" list="subName">
					<datalist id="subName">
						<c:forEach var="subName" items="${subNameList}">
							<option value="${subName}">
						</c:forEach>
					</datalist>
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
		<c:choose>
			<c:when test="${subjectList.isEmpty() == false}">
				<h4>
					<span style="font-weight: 600;">강의 목록</span>&nbsp;
					<span style="color:gray; font-size:18px;">[총 ${subjectCount}건]</span>
				</h4>
				<table border="1" class="sub--list--table">
					<thead>
						<tr>
							<th>단과대학</th>
							<th>개설학과</th>
							<th>학수번호</th>
							<th>강의구분</th>
							<th style="width: 200px;">강의명</th>
							<th>담당교수</th>
							<th>학점</th>
							<th>요일시간 (강의실)</th>
							<th>현재인원</th>
							<th>정원</th>
							<th>강의계획서</th>
						</tr>
					</thead>
		
					<tbody>
						<c:forEach var="subject" items="${subjectList}">
							<tr>
								<td>${subject.collName}</td>
								<td>${subject.deptName}</td>
								<td>${subject.id}</td>
								<td>${subject.type}</td>
								<td class="sub--list--name">${subject.name}</td>
								<td>${subject.professorName}</td>
								<td>${subject.grades}</td>
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
								<td>${subject.numOfStudent}</td>
								<td>${subject.capacity}</td>
								<td>
									<ul class="d-flex justify-content-center sub--plan--view" style="margin: 0;">
										<li style="height: 24px;"><a href="/subject/syllabus/${subject.id}" onclick="window.open(this.href, '_blank', 'width=1000, height=1000'); return false;">조회</a>
										<li style="height: 24px;"><a href="/subject/syllabus/${subject.id}" onclick="window.open(this.href, '_blank', 'width=1000, height=1000'); return false;"><span class="material-symbols-outlined">content_paste_search</span></a>
									</ul>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${pageCount != null}">
				<ul class="page--list">
					<c:forEach var="i" begin="1" end="${pageCount}" step="1">
						<c:choose>
							<c:when test="${i == page}">
								<li><a href="/sugang/subjectList/${i}" style="font-weight: 700; color: #007bff">${i}</a>									
							</c:when>
							<c:otherwise>
								<li><a href="/sugang/subjectList/${i}">${i}</a>									
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</ul>
				</c:if>
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

