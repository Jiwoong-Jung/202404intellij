<%@ page language="java" contentType="text/html; charset-UTF-8" pageEncoding="utf-8" %>

<%@ include file="layout/header.jsp" %>

<!-- toast -->
<div class="toast_area" style="position: fixed; top: 79px; right: 10px;">
    <div class="toast_container"></div>
</div>
<main class="container">
    <div class="d-flex justify-content-center m-5">
        <%--    검생창    --%>
        <div class="d-flex box_search">
            <div class="dropdown px-2">
                <button type="button" class="search_option btn dropdown-toggle align-top shadow-none"
                        data-toggle="dropdown">
                    전체
                </button>
                <div class="dropdown-menu">
                    <div class="dropdown-item">전체</div>
                    <div class="dropdown-item">강좌명</div>
                    <div class="dropdown-item">교수명</div>
                </div>
            </div>

            <div class="box_search_input">
                <input type="text" name="" id="" class="search_input" placeholder="검색어를 입력하세요">
            </div>

            <div class="box_search_img">
                <i class="fas fa-search"></i>
            </div>
        </div>
    </div>
    <%--  조회 결과 테이블  --%>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">전공</th>
            <th scope="col">강의명</th>
            <th scope="col">교수명</th>
            <th scope="col">학점</th>
            <th scope="col">시간</th>
            <th scope="col">장바구니</th>
            <th scope="col">수강신청</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="lecture" items="${lectures}">
            <tr>
                <td>${lecture.id}</td>
                <td>${lecture.major.name}</td>
                <td>${lecture.name}</td>
                <td>${lecture.lecturer}</td>
                <td>${lecture.credit}</td>
                <td>${lecture.day.getValue()} ${lecture.period.getStartTime()} - ${lecture.period.getEndTime()}</td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="basket.save(${lecture.id})">담기</button>
                </td>
                <td>
                    <button type="button" class="btn btn-primary" onclick="enrollment.save(${lecture.id})">신청</button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>

<script src="/assets/js/lecturepage-logic.js" defer></script>
<script>
    const dropdown_toggle = document.querySelector('.dropdown-toggle');
    const dropdown_item = document.querySelectorAll(".dropdown-item");

    dropdown_item.forEach((item) => {
        item.addEventListener('click', () => {
            dropdown_toggle.innerHTML = item.innerHTML;
        })
    });
</script>

<%--임시--%>
<script>
    const search_input = document.querySelector('.search_input');

    search_input.addEventListener('keypress', evnet => {
        if (evnet.key == 'Enter') {
            let search_option = document.querySelector('.search_option').innerText.trim();
            let search_word = search_input.value;
            if (search_option === '전체') {
                location.href = '/lecture/search?searchBy=LECTURER_AND_NAME&searchMessage=' + search_word;
            } else if (search_option === '강좌명') {
                location.href = '/lecture/search?searchBy=NAME&searchMessage=' + search_word;
            } else if (search_option === '교수명') {
                location.href = '/lecture/search?searchBy=LECTURER&searchMessage=' + search_word;
            }
        }
    });
</script>

<%--toast 스크롤 따라가게 하기--%>
<script>
    const nav = document.querySelector('.navbar');
    const navTop = nav.offsetHeight;
    const toast__area = document.querySelector('.toast_area');

    function fixNav() {
        if (window.scrollY >= navTop) {
            toast__area.style.top = '6px';
        } else {
            toast__area.style.top = navTop + 10 - window.scrollY + 'px';
        }
    }

    window.addEventListener('scroll', fixNav);
</script>

<%@ include file="layout/footer.jsp" %>