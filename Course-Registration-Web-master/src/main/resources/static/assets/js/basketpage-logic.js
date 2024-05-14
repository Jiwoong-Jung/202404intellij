// Bootstrap alert 동적 생성 함수
let resultCount = 0;
let basketResultMessageBox = document.querySelector('.basket_result_message_box');
let enrollmentResultMessageBox = document.querySelector('.enrollment_result_message_box');

function createResultAlert(target, result, message) {
    resultCount += 1;
    let specificClass = 'alert-' + resultCount;
    let resultMessageBox = target;
    let resultMessage = document.createElement('div');
    resultMessage.classList.add('alert', result, 'fade', 'show', specificClass);
    resultMessage.innerText = message;

    let resultMessageCloseBtnBox = document.createElement('button');
    resultMessageCloseBtnBox.setAttribute('type', 'button');
    resultMessageCloseBtnBox.setAttribute('data-dismiss', 'alert');
    resultMessageCloseBtnBox.setAttribute('aria-label', 'Close');
    resultMessageCloseBtnBox.classList.add('close')

    let resultMessageCloseBtn = document.createElement('span');
    resultMessageCloseBtn.setAttribute('aria-hidden', 'true')
    resultMessageCloseBtn.innerText = '×'

    resultMessageBox.append(resultMessage);
    resultMessage.append(resultMessageCloseBtnBox);
    resultMessageCloseBtnBox.appendChild(resultMessageCloseBtn);

    setTimeout(() => {
        $('.' + specificClass).alert('close');
        resultCount = 0
    }, 5000)

}

// Bootstrap 모달 동적 생성 로직
let lectureID
let modalTitle = document.querySelector('.modal-title');
let modalBody = document.querySelector('.modal-body');
let MODALLOGICTYPE = {
    BASKET: {
        'delete': {name: "장바구니 삭제"}
    },
    ENROLLMENT: {
        'save': {name: "수강신청 저장"},
        'delete': {name: "수강신청 삭제"}
    }
};
let modalLogic;
let deleteTargetNode;

let toBeCreatedList = [
    {
        button: '.btn_enrollment_save',
        title: '수강신청',
        content: '해당 과목을 수강신청 하시겠습니까?',
        logic: MODALLOGICTYPE.ENROLLMENT.save
    },
    {
        button: '.btn_enrollment_delete',
        title: '수강신청',
        content: '해당 과목을 수강 취소하시겠습니까?',
        logic: MODALLOGICTYPE.ENROLLMENT.delete
    },
    {
        button: '.btn_basket_delete',
        title: '장바구니',
        content: '해당 과목을 장바구니에서 삭제하시겠습니까?',
        logic: MODALLOGICTYPE.BASKET.delete
    }
];

toBeCreatedList.forEach((item) => {
    let btns = document.querySelectorAll(item.button)
    btns.forEach(btn => {
        btn.addEventListener('click', function (event) {
            createModal(item.title, item.content, event, item.logic)
        })
    })
});

function createModal(title, content, event, logic) {
    modalTitle.innerText = title;
    modalBody.innerText = content
    lectureID = event.currentTarget.childNodes[1].value;
    deleteTargetNode = event.currentTarget;
    modalLogic = logic
    $('#myModal').modal('show');
}

///////////////////////////////////////////////////
// 모달 확인 버튼 클릭 후 발생하는 이벤트
let btn_modal_ok = document.querySelector('#btn_modal_ok');
btn_modal_ok.addEventListener('click', () => {
    $('#myModal').modal('hide');
    if (modalLogic === MODALLOGICTYPE.ENROLLMENT.save) {
        enrollment.save(lectureID);
    } else if (modalLogic === MODALLOGICTYPE.BASKET.delete) {
        basket.delete(deleteTargetNode, lectureID);
    } else if (modalLogic === MODALLOGICTYPE.ENROLLMENT.delete) {
        enrollment.delete(deleteTargetNode, lectureID);
    }
});
///////////////////////////////////////////////////

// 수강신청
let enrollment = {

    save: function (lectureID) {
        $.ajax({
            type: "POST",
            url: 'api/enrollment/' + lectureID,
        }).done(function (response) {
            createResultAlert(basketResultMessageBox, 'alert-success', response.message);

            // 테이블 데이터 동적 생성 로직
            let enrollment_table_body = document.querySelector('.enrollment_table_body');
            let tableRow = document.createElement('tr');
            let tableData_id = document.createElement('td');
            let tableData_major = document.createElement('td');
            let tableData_Name = document.createElement('td');
            let tableData_lecturer = document.createElement('td');
            let tableData_credit = document.createElement('td');
            let tableData_time = document.createElement('td');
            let tableData_button = document.createElement('td');
            let deleteButton = document.createElement('button');
            let hiddenInput = document.createElement('input')

            tableData_id.innerText = response.data.id;
            tableData_major.innerText = response.data.major;
            tableData_Name.innerText = response.data.name;
            tableData_lecturer.innerText = response.data.lecturer;
            tableData_credit.innerText = response.data.credit;
            tableData_time.innerText = response.data.day + ' ' + response.data.startTime + ' - ' + response.data.endTime;
            deleteButton.innerText = '삭제';
            deleteButton.classList.add('btn_enrollment_delete', 'btn', 'btn-danger');
            deleteButton.addEventListener('click', function (event) {
                createModal('수강신청', '해당 과목을 수강 취소하시겠습니까?', event, MODALLOGICTYPE.ENROLLMENT.delete)
            });
            hiddenInput.setAttribute('type', 'hidden');
            hiddenInput.setAttribute('value', response.data.id);

            deleteButton.append(hiddenInput)
            tableData_button.append(deleteButton)
            tableRow.append(tableData_id);
            tableRow.append(tableData_major);
            tableRow.append(tableData_Name);
            tableRow.append(tableData_lecturer);
            tableRow.append(tableData_credit);
            tableRow.append(tableData_time);
            tableRow.append(tableData_button);
            enrollment_table_body.append(tableRow);
            // 수강 남은 학점 표시
            document.querySelector('.left_credit').innerText = response.data['leftCredit'];
        }).fail(function (error) {
            createResultAlert(basketResultMessageBox, 'alert-danger', error.responseJSON["error-message"]);
        });
    },

    delete: function (event, lectureID) {
        $.ajax({
            type: "DELETE",
            url: 'api/enrollment/' + lectureID,
        }).done(function (response) {
            createResultAlert(enrollmentResultMessageBox, 'alert-success', response.message);
            // 삭제할 노드 구한 후 부모노드를 구해서 삭제.
            let removeTargetNode = event.parentNode.parentNode;
            event.parentNode.parentNode.parentNode.removeChild(removeTargetNode);
            // 수강 남은 학점 표시
            document.querySelector('.left_credit').innerText = response.data.leftCredit;
        }).fail(function (error) {
            console.log(error.responseJSON["error-message"]);
        });
    }
}

// 장바구니
let basket = {

    save: function (lectureID) {
        $.ajax({
            type: "POST",
            url: 'api/basket/' + lectureID,
        }).done(function (response) {
            createResultAlert(basketResultMessageBox, 'alert-success', response.message);
        }).fail(function (error) {
            createResultAlert(basketResultMessageBox, 'alert-danger', error.responseJSON["error-message"]);
        });
    },

    delete: function (event, lectureID) {
        $.ajax({
            type: "DELETE",
            url: 'api/basket/' + lectureID,
        }).done(function (response) {
            createResultAlert(basketResultMessageBox, 'alert-success', response.message);
            // 삭제할 노드 구한 후 부모노드를 구해서 삭제.
            let removeTargetNode = event.parentNode.parentNode;
            event.parentNode.parentNode.parentNode.removeChild(removeTargetNode);
        }).fail(function (error) {
            console.log(error.responseJSON["error-message"]);
        });
    }

}