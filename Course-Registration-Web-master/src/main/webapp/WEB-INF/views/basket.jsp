<%@ page language="java" contentType="text/html; charset-UTF-8" pageEncoding="utf-8" %>

<%@ include file="layout/header.jsp" %>
<main class="container" style="padding: 50px 0 150px">
    <div class="d-flex justify-content-between">
        <h2>장바구니</h2>
        <p style="font-size: 20px">신청가능학점 <span class="left_credit"
                                                style="font-weight: bold; color: #002968">${credit}</span>학점</p>
    </div>
    <%--  장바구니 테이블  --%>
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
        <c:forEach var="lecture" items="${basket_lectures}">
            <tr>
                <td>${lecture.id}</td>
                <td>${lecture.major.name}</td>
                <td>${lecture.name}</td>
                <td>${lecture.lecturer}</td>
                <td>${lecture.credit}</td>
                <td>${lecture.day.getValue()} ${lecture.period.getStartTime()} - ${lecture.period.getEndTime()}</td>
                <td>
                    <button type="button" class="btn_basket_delete btn btn-danger">
                        삭제
                        <input type="hidden" value="${lecture.id}">
                    </button>
                </td>
                <td>
                    <button type="button" class="btn_enrollment_save btn btn-primary">
                        신청
                        <input type="hidden" value="${lecture.id}">
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 결과 메시지 -->
    <div class="basket_result_message_box"></div>
    <%--  수강신청 테이블  --%>
    <h2>수강신청</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">전공</th>
            <th scope="col">강의명</th>
            <th scope="col">교수명</th>
            <th scope="col">학점</th>
            <th scope="col">시간</th>
            <th scope="col">수강신청</th>
        </tr>
        </thead>
        <tbody class="enrollment_table_body">
        <c:forEach var="lecture" items="${enrollment_lectures}">
            <tr>
                <td>${lecture.id}</td>
                <td>${lecture.major.name}</td>
                <td>${lecture.name}</td>
                <td>${lecture.lecturer}</td>
                <td>${lecture.credit}</td>
                <td>${lecture.day.getValue()} ${lecture.period.getStartTime()} - ${lecture.period.getEndTime()}</td>
                <td>
                    <button type="button" class="btn_enrollment_delete btn btn-danger">
                        삭제
                        <input type="hidden" value="${lecture.id}">
                    </button>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 결과 메시지 -->
    <div class="enrollment_result_message_box"></div>
</main>
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                modal body
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                <button type="button" id="btn_modal_ok" class="btn btn-primary">확인</button>
            </div>
        </div>
    </div>
</div>

<%-- javascript --%>
<script src="/assets/js/basketpage-logic.js" defer></script>

<%@ include file="layout/footer.jsp" %>