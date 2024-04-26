<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>주문 결과</title>
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
<h2>주문 결과</h2>
${pizza.total}
<div id="content">준비중입니다.</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
    setInterval(function() {
        $.ajax({
            url: "/orderList4", // 여기에 요청을 보낼 URL을 입력하세요
            data: {"id" : ${pizza.id} },
            type: "GET", // 요청 유형 (GET, POST 등)
            success: function(data) {
                console.log(data); // 성공적으로 데이터를 받으면 콘솔에 출력
                // console.log("화면 수정");
                $('#content').html(data);
            },
            error: function(error) {
                console.log('Error: ' + error); // 에러가 발생하면 콘솔에 출력
            }
        });
    }, 1000); // 1초마다 실행 (10000 밀리초 = 10초)
</script>
</body>
</html>