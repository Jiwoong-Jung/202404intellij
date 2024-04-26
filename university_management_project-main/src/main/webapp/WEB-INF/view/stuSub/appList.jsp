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
					<td><a href="/sugang/subjectList/1">강의 시간표 조회</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/pre/1">예비 수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/preAppList?type=1">수강 신청</a></td>
				</tr>
				<tr>
					<td><a href="/sugang/list" class="selected--menu">수강 신청 내역 조회</a></td>
				</tr>
			</table>
		</div>
	</div>

	<!-- 메인 div -->
	<main>
		<h1>수강 신청 내역 조회</h1>
		<div class="split--div"></div>
		<!-- 여기에 내용 넣기 -->
		<div style="width: 100%">
			<c:choose>
				<c:when test="${stuSubList.size() > 0}">

					<h4>
						<span style="font-weight: 600;">신청 내역</span>&nbsp;
						<span style="color:gray; font-size:18px;">[총 ${sumGrades}학점]</span>
					</h4>
					<table border="1" class="sub--list--table">
						<thead>
							<tr>
								<th>학수번호</th>
								<th style="width: 250px;">강의명</th>
								<th>담당교수</th>
								<th>학점</th>
								<th>요일시간 (강의실)</th>
								<th>현재인원</th>
								<th>정원</th>
								<th>수강신청</th>
							</tr>
						</thead>

						<tbody>
							<c:forEach var="stuSub" items="${stuSubList}">
								<tr>
									<td>${stuSub.subjectId}</td>
									<td class="sub--list--name">${stuSub.subjectName}</td>
									<td>${stuSub.professorName}</td>
									<td>${stuSub.grades}</td>
									<td>
										<c:choose>
											<c:when test="${stuSub.startTime < 10}">
												${stuSub.subDay} 0${stuSub.startTime}:00-${stuSub.endTime}:00&nbsp;(${stuSub.roomId})								
											</c:when>
											<c:otherwise>
												${stuSub.subDay} ${stuSub.startTime}:00-${stuSub.endTime}:00&nbsp;(${stuSub.roomId})							
											</c:otherwise>
										</c:choose>
									</td>
									<td>${stuSub.numOfStudent}</td>
									<td>${stuSub.capacity}</td>
									<td class="sub--list--button--row">
										<form action="/sugang/deleteApp/${stuSub.subjectId}?type=1" method="post">
											<input type="hidden" name="_method" value="delete">
											<button type="submit" onclick="return confirm('수강신청을 취소하시겠습니까?');" style="background-color: #a7a7a7;">취소</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:when>

				<c:otherwise>
					<p class="no--list--p">수강 신청 내역이 없습니다.</p>
				</c:otherwise>
			</c:choose>
		</div>



	</main>
</div>

<%@ include file="/WEB-INF/view/layout/footer.jsp"%>

</div>

</body>
</html>

