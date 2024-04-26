<%@page import="org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ include file="/WEB-INF/view/layout/header.jsp"%>
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Rounded:opsz,wght,FILL,GRAD@48,400,1,0" />
<link rel="stylesheet" href="/css/mainPage.css">

<script>
	<%
	PrincipalDto principal = (PrincipalDto)session.getAttribute(Define.PRINCIPAL);
	if(new BCryptPasswordEncoder().matches(principal.getId().toString(), principal.getPassword())){%>
	function pop()
	{
		window.open("/guide", "비밀번호 변경 안내", "width=450,height=300,history=no,resizable=no,status=no,scrollbars=yes,menubar=no");
	}
	<%}%>
</script>

</head>
<body onLoad="javascript:pop()">

<!-- 세부 메뉴 + 메인 -->
<div class="d-flex justify-content-center align-items-start" style="min-width: 100em;">

	<div>
		<img alt="" src="/images/main_photo.jpg" class="main--page--img">
		<div class="d-flex justify-content-center align-items-start">
			<div class="main--page--div">
				<div class="d-flex">
					<!-- 공지사항 -->
					<div class="main--page--notice">
						<h3>
							<a href="/notice">공지사항</a>
						</h3>
						<div class="main--page--split"></div>
						<table>
							<c:forEach var="notice" items="${noticeList}">
								<tr>
									<td><a href="/notice/read?id=${notice.id}">${notice.category}&nbsp;${notice.title}</a></td>
									<td>${notice.dateFormat()}
								</tr>
							</c:forEach>
						</table>
					</div>
					<div class="main--page--calander">
						<h3>
							<a href="/schedule">학사일정</a>
						</h3>
						<div class="main--page--split"></div>
						<table>
							<c:forEach var="schedule" items="${scheduleList}">
								<tr>
									<td>${schedule.startDay.substring(5)}&nbsp;-&nbsp;${schedule.endDay.substring(5)}</td>
									<td>${schedule.information}</td>
								</tr>
							</c:forEach>
						</table>

					</div>
				</div>
			</div>
			<div>
				<!-- 사용자 간단한 프로필 -->
				<div class="main--page--profile">
					<ul class="d-flex align-items-start" style="margin: 0;">
						<li><span class="material-symbols-rounded" style="margin-top: 2px;">person</span>&nbsp;&nbsp;
						<li style="font-weight: 600; font-size: 18px;">${userInfo.name}님,&nbsp;환영합니다.
					</ul>
					<hr style="width: 100%;">
						<c:choose>
							<c:when test="${principal.getUserRole().equals(\"student\")}">
								<table>
									<tr>
										<td>이메일</td>
										<td>${userInfo.email}</td>
									</tr>
									<tr>
										<td>소속</td>
										<td>${userInfo.deptName}</td>
									</tr>
									<tr>
										<td>학기</td>
										<td>${userInfo.grade}학년&nbsp;${userInfo.semester}학기</td>
									</tr>
									<tr>
										<td>학적상태</td>
										<td>${currentStatus}</td>
									</tr>
								</table>
								<div class="profile--button--div">
									<a href="/info/student"><button>마이페이지</button></a>
									<a href="/logout"><button>로그아웃</button></a>
								</div>
							</c:when>
							<c:when test="${principal.getUserRole().equals(\"staff\")}">
								<table>
									<tr>
										<td>이메일</td>
										<td>${userInfo.email}</td>
									</tr>
									<tr>
										<td>소속</td>
										<td>교직원</td>
									</tr>
								</table>
								<div class="profile--button--div">
									<a href="/info/staff"><button>마이페이지</button></a>
									<a href="/logout"><button>로그아웃</button></a>
								</div>
							</c:when>
							<c:otherwise>
								<table>
									<tr>
										<td>이메일</td>
										<td>${userInfo.email}</td>
									</tr>
									<tr>
										<td>소속</td>
										<td>${userInfo.deptName} 교수</td>
									</tr>
								</table>
								<div class="profile--button--div">
									<a href="/info/professor"><button>마이페이지</button></a>
									<a href="/logout"><button>로그아웃</button></a>
								</div>
							</c:otherwise>
						</c:choose>
				</div>
				<br>
				<c:choose>
					<c:when test="${breakAppSize > 0}">
						<div class="main--page--info">
							<ul class="d-flex align-items-start" style="margin: 0;">
								<li><span class="material-symbols-rounded" style="margin-top: 2px; color:#fccb03;">notifications_active</span>&nbsp;&nbsp;
								<li style="font-weight: 600; font-size: 18px;">업무 알림
							</ul>
							<p><a href="/break/list/staff">처리되지 않은 휴학 신청이 존재합니다.</a></p>
						</div>
					</c:when>
					<c:when test="${breakAppSize == 0}">
						<div class="main--page--info">
							<ul class="d-flex align-items-start" style="margin: 0;">
								<li><span class="material-symbols-rounded" style="margin-top: 2px;">notifications</span>&nbsp;&nbsp;
								<li style="font-weight: 600; font-size: 18px;">업무 알림
							</ul>
							<p>처리해야 할 업무가 없습니다.</p>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
	</div>
</div>

  		<footer>
			COPYRIGHT(C) 2023 <a href="https://github.com/seoyounglee0105/university_management_project">GREAN UNIVERSITY</a>. ALL RIGHTS RESERVED.
		</footer>

</div>

</body>
</html>

