// Toast 동적 생성
let toastCount = 0;
let TOASTTYPE = {
    'SUCCESS': 'text-primary',
    'FAIL': 'text-danger'
}

function createMyToast(type, title, content, time) {
    toastCount += 1;
    let specificClass = 'myToast' + toastCount;
    let toast_container = document.querySelector('.toast_container');

    let toast = document.createElement('div');
    toast.classList.add('toast', specificClass);
    toast.setAttribute('role', 'alert');
    toast.setAttribute('aria-live', 'assertive');
    toast.setAttribute('data-delay', time);
    toast.style.minWidth = '300px';

    let toast_header = document.createElement('div');
    toast_header.classList.add('toast-header');

    let toast_header__strong = document.createElement('storng');
    toast_header__strong.classList.add('mr-auto', type)
    toast_header__strong.innerText = title;

    let toast_header__small = document.createElement('small');
    toast_header__small.classList.add('text-muted');
    toast_header__small.innerText = 'just now';

    let toast_header__button = document.createElement('button');
    toast_header__button.setAttribute('type', 'button');
    toast_header__button.setAttribute('data-dismiss', 'toast');
    toast_header__button.classList.add('ml-2', 'mb-1', 'close');

    let toast_header__button__span = document.createElement('span');
    toast_header__button__span.setAttribute('aria-hidden', 'true');
    toast_header__button__span.innerText = "×"

    let toast_body = document.createElement('div');
    toast_body.classList.add('toast-body');
    toast_body.innerText = content;

    //  결합
    toast_header__button.append(toast_header__button__span);
    toast_header.append(toast_header__strong);
    toast_header.append(toast_header__small);
    toast_header.append(toast_header__button);
    toast.append(toast_header);
    toast.append(toast_body);
    toast_container.append(toast);

    $('.' + specificClass).toast('show');
    setTimeout(() => {
        toast_container.removeChild(toast);
    }, time + 2000);
}

// 수강신청
let enrollment = {

    save: function (lectureID) {
        $.ajax({
            type: "POST",
            url: '/api/enrollment/' + lectureID,
        }).done(function (response) {
            createMyToast(TOASTTYPE.SUCCESS, '수강신청', response.message, 5000);
        }).fail(function (error) {
            createMyToast(TOASTTYPE.FAIL, '수강신청', error.responseJSON["error-message"], 5000);
        });
    },

}

// 장바구니
let basket = {

    save: function (lectureID) {
        $.ajax({
            type: "POST",
            url: '/api/basket/' + lectureID,
        }).done(function (response) {
            createMyToast(TOASTTYPE.SUCCESS, '장바구니', response.message, 5000);
        }).fail(function (error) {
            createMyToast(TOASTTYPE.FAIL, '장바구니', error.responseJSON["error-message"], 5000);
        });
    },

}