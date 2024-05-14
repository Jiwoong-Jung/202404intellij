let index = {
    init: function () {
        $('#btn-sign-up').on('click', () => {
            this.signUp();
        });

        $('#btn-login').on('click', () => {
            this.login();
        });

        $('#btn-update').on('click', () => {
            this.update();
        });
    },

    signUp: function () {
        let data = {
            email: $('#email').val(),
            password: $('#password').val()
        }
        $.ajax({
            type: "POST",
            url: "/auth/sign-up",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8",
            dataType: "json"
        }).done(function (response) {
            alert(response.message);
            location.href = "/login"
        }).fail(function (error) {
            const e = error.responseJSON['error-message'];
            if (e.email !== undefined && e.password !== undefined) {
                alert(e.email + '\n' + e.password)
            } else if (e.email !== undefined && e.password === undefined) {
                alert(e.email);
            } else if (e.email === undefined && e.password !== undefined) {
                alert(e.password);
            } else {
                alert(e);
            }
        });
    },

    update: function () {
        let data = {
            id: $('#id').val(),
            username: $('#username').val(),
            email: $('#email').val(),
            password: $('#password').val()
        }

        // ajax 통신을 이용해서 3개의 데이터를 json 으로 변경하여 insert 요청.
        $.ajax({
            type: "PUT",
            url: "/user",
            data: JSON.stringify(data),
            contentType: "application/json; charset=utf-8", // body data 가 어떤 타입인지(MIME)
            dataType: "json"
        }).done(function (response) {
            alert('회원정보 수정이 완료되었습니다.');
            location.href = '/';
            console.log(response);
        }).fail(function (error) {
            console.log(error.responseJSON["error-message"]);
        });
    },
}

index.init()