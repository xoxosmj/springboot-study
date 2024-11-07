$(function () {

    let isIdValid = false;

    // 1. ID 입력란에서 포커스가 벗어났을 때 (focusout) 이벤트 발생
    $('#id').focusout(function () {
        $('#idDiv').empty(); // 중복 확인 메시지 영역 초기화

        let id = $('#id').val(); // 입력된 ID 값을 가져옴

        // 2. 입력란이 비어 있는지 확인
        if (id === '') {
            // 비어 있으면 '먼저 아이디 입력' 메시지를 빨간색으로 표시
            $('#idDiv').html("<span style='color: red;'>먼저 아이디 입력</span>");
        } else {
            // 비어있지 않으면 서버에 ID 중복 확인을 위한 AJAX 요청
            $.ajax({
                type: 'post', // HTTP 메서드로 POST를 사용
                url: '/user/getExistId', // 서버의 경로 설정 (서버에 요청할 엔드포인트)
                data: {'id': id}, // 서버에 전달할 데이터로 `id` 값을 전달
                dataType: 'text', // 서버 응답 데이터 형식을 텍스트로 설정

                // 3. 서버 응답을 성공적으로 받았을 때 실행되는 함수
                success: function (data) {
                    // 서버로부터 받은 응답이 'exist'인지 확인
                    if (data === 'exist') {
                        // 'exist'라면, '사용 불가능' 메시지를 빨간색으로 표시
                        $('#idDiv').html('사용 불가능').css('color', 'red');
                        isIdValid = false;
                    } else {
                        // 'exist'가 아니면, '사용 가능' 메시지를 파란색으로 표시
                        $('#idDiv').html('사용 가능').css('color', 'blue');
                        isIdValid = true;
                    }
                },

                // 4. 서버 응답 실패 시 실행되는 함수
                error: function (e) {
                    // 오류 메시지를 콘솔에 출력하고, 사용자에게 알림 표시
                    console.error("Error occurred while checking ID:", e);
                    alert('아이디 확인 중 오류가 발생했습니다.');
                }
            })
        }
    })

    $('#writeBtn').click(function () {
        $('#nameDiv').empty();
        $('#idDiv').empty();
        $('#pwdDiv').empty();

        if (!isIdValid) { // isIdValid 값이 false면 중복된 아이디거나, 확인되지 않은 아이디
            if($('#id').val() === ''){ //만약 아이디 입력값이 없으면
                $('#idDiv').html('아이디 입력').css('color', 'red');
                $('#id').focus();
            } else{ //아이디 입력값이 있는데 isIdValid가 false라는것은, 사용 불가능한 아이디라는것
                alert('중복된 아이디입니다. 다른 아이디를 사용하세요.');
                $('#id').focus();
            }
            return false; // submit 막기
        } else if ($('#name').val() == '') {
            // ... (기존 코드 - 이름 입력 확인)
        } else if ($('#pwd').val() == '') {
            // ... (기존 코드 - 비밀번호 입력 확인)
        } else {
            $('#userWriteForm').submit();
        }
    });
});