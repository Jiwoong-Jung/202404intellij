<%@ page language="java" contentType="text/html; charset-UTF-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%-- spring security tags 이용 --%>
<%-- https://docs.spring.io/spring-security/site/docs/3.0.x/reference/el-access.html --%>
<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal" var="principal"/>
</sec:authorize>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>::명지대학교 수강신청 시스템::</title>
    <%--  jQuery  --%>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
    <%--  bootstrap  --%>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
          integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <%--  summernote  --%>
    <link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-bs4.min.css" rel="stylesheet">
    <!-- fontawesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.2/css/all.css"
          integrity="sha384-vSIIfh2YWi9wW0r9iZe7RJPrKwp6bG+s9QZMoITbCckVJqGCCRhc+ccxNcdpHuYu" crossorigin="anonymous">
    <%--  css  --%>
    <link rel="stylesheet" href="/assets/css/index.css">
    <link rel="stylesheet" href="/assets/css/lecture.css">
    <style>
        .navbar-brand img {
            width: 170px;
        }

        .nav-item a {
            color: #F2F2F2;
        }

        .nav-item a:hover {
            color: #BDBDBD;
        }
    </style>
</head>
<body>
<header>
    <nav class="navbar navbar-expand-md" style="background-color: #002968">
        <div class="container">
            <!-- Brand -->
            <div>
                <a class="navbar-brand" href="/">
                    <img src="/assets/images/mju-logo-white.png" alt="logo">
                </a>
            </div>

            <!-- Toggler/collapsibe Button -->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar links -->
            <div class="collapse navbar-collapse justify-content-end" id="collapsibleNavbar">
                <c:choose>
                    <c:when test="${empty principal}">
                        <ul class="navbar-nav text-center">
                            <li class="nav-item">
                                <a class="nav-link" href="/auth/login">로그인</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/auth/sign-up">회원가입</a>
                            </li>
                        </ul>
                    </c:when>
                    <c:otherwise>
                        <ul class="navbar-nav">
                            <li class="nav-item">
                                <a class="nav-link" href="/basket">장바구니</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="/lecture">강의조회</a>
                            </li>
                            <sec:authorize access="hasRole('ADMIN')">
                                <li class="nav-item">
                                    <a class="nav-link" href="#">회원관리</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">강좌관리</a>
                                </li>
                            </sec:authorize>
                            <li class="nav-item">
                                <a class="nav-link" href="/logout">로그아웃</a>
                            </li>
                        </ul>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </nav>

</header>