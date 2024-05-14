<%@ page language="java" contentType="text/html; charset-UTF-8" pageEncoding="utf-8" %>

<%@ include file="layout/header.jsp" %>

<main class="my-5">
    <div class="row form-group">
        <div class="col-md-6 offset-md-3 ">
            <div class="card">
                <div class="card-header">로그인</div>
                <div class="card-body">
                    <form action="/auth/login" method="post">
                        <input type="text" name="username" id="username" class="form-control mb-2"
                               placeholder="Username" required>
                        <input type="password" name="password" id="password" class="form-control mb-3"
                               placeholder="Password" required>
                        <button type="submit" id="create-user" class="btn btn-primary btn-block">로그인</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</main>

<script src="/assets/js/user.js" defer></script>
<%@ include file="layout/footer.jsp" %>