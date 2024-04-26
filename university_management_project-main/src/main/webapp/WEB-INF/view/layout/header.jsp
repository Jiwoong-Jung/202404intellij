<%@page import="com.green.university.dto.response.PrincipalDto"%>
<%@page import="com.green.university.utils.Define"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>그린대학교 학사관리시스템</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.4/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
<style>
</style>
</head>
<body>
	<header class="d-flex flex-column">
		<div class="header--top">
			<ul>
				<li class="material--li"><span class="material-symbols-outlined">account_circle</span>
				<li>${principal.name}님 (${principal.id})
				<li style="margin: 0 15px;">ㅣ
				<li class="material--li"><span style="color: #9BD2EC;" class="material-symbols-outlined">logout</span>
				<li><a href="/logout">로그아웃</a>
			</ul>
		</div>

		<nav class="main--menu">
			<a href="/"><img class="logo" alt="" src="/images/logo.png"></a>
			<!-- userRole에 따라 메뉴 다르게 표시 -->
			<c:choose>
				<c:when test="${principal.userRole.equals(\"student\")}">
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/info/student">MY</a>
						<li><a href="/subject/list/1">수업</a>
						<li><a href="/sugang/subjectList/1">수강신청</a>
						<li><a href="/grade/thisSemester">성적</a>
						<li><a href="/notice">학사정보</a>
					</ul>
				</c:when>

				<c:when test="${principal.userRole.equals(\"professor\")}">
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/info/professor">MY</a>
						<li><a href="/subject/list/1">수업</a>
						<li><a href="/notice">학사정보</a>
					</ul>
				</c:when>

				<c:otherwise>
					<ul>
						<li><a href="/">홈</a>
						<li><a href="/info/staff">MY</a>
						<li><a href="/user/studentList">학사관리</a>
						<li><a href="/admin/college">등록</a>
						<li><a href="/notice">학사정보</a>
					</ul>
				</c:otherwise>
			</c:choose>

		</nav>
	</header>