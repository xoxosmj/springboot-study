$(function() {
    // 아이디 중복체크
    $('#id').focusout(function() {
        $('#idDiv').empty();

        let id = $('#id').val();

        if (id === '') {
            $('#idDiv').html("<span style='color: red;'>먼저 아이디 입력</span>");
        } else {
            $.ajax({
                type: 'post',
                url: '/user/getExistId', // 경로가 서버에 맞게 설정되어 있는지 확인 필요
                data: { 'id': id },
                dataType: 'text',
                success: function(data) {
                    if (data === 'exist') {
                        $('#idDiv').html('사용 불가능').css('color', 'red');
                    } else {
                        $('#idDiv').html('사용 가능').css('color', 'blue');
                    }
                },
                error: function(e) {
                    console.error("Error occurred while checking ID:", e);
                    alert('아이디 확인 중 오류가 발생했습니다.');
                }
            });
        }
    });

    // 등록
    $('#writeBtn').click(function() {
        $('#nameDiv').empty();
        $('#idDiv').empty();
        $('#pwdDiv').empty();

        let name = $('#name').val();
        let id = $('#id').val();
        let pwd = $('#pwd').val();

        if (name === '') {
            $('#nameDiv').html("<span style='color: red;'>이름 입력</span>");
        } else if (id === '') {
            $('#idDiv').html("<span style='color: red;'>아이디 입력</span>");
        } else if (pwd === '') {
            $('#pwdDiv').html("<span style='color: red;'>비밀번호 입력</span>");
        } else {
            $.ajax({
                type: 'post',
                url: '/user/write', // 경로가 서버에 맞게 설정되어 있는지 확인 필요
                data: $('#userWriteForm').serialize(),
                success: function() {
                    alert('회원가입 완료');
                    location.href = '/user/list';
                },
                error: function(e) {
                    console.error("Error occurred during registration:", e);
                    alert('회원가입 중 오류가 발생했습니다.');
                }
            });
        }
    });
});
