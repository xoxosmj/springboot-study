$(function () {

    //아이디 중복체크
    $('#id').focusout(function () {
        $('#idDiv').empty();

        let id = $('#id').val();

        if (id == '') {
            $('#idDiv').html("<span style='color: red;'>먼저 아이디 입력</span>");
        } else {
            $.ajax({
                type: 'post',
                url: '/member/isExistId',
                data: {'id': id},
                dataType: 'text',
                success: function (data) {
                    if (data == 'exist') {
                        $('#idDiv').html('사용 불가능');
                        $('#idDiv').css('color', 'red');
                    } else {
                        $('#idDiv').html('사용 가능');
                        $('#idDiv').css('color', 'blue');
                    }
                },
                error: function (e) {
                    console.log(e);
                }
            });
        }
    });

    //가입
    $('#registerBtn').click(function () {
        $('#idDiv').empty();
        $('#pwdDiv').empty();
        $('#nameDiv').empty();

        if ($('#id').val() == '') {
            $('#idDiv').text('아이디 입력');
            $('#id').focus();
        } else if ($('#pwd').val() == '') {
            $('#pwdDiv').text('비밀번호 입력');
            $('#pwd').focus();
        } else if ($('#name').val() == '') {
            $('#nameDiv').text('이름 입력');
            $('#name').focus();
        } else {
            $.ajax({
                type: 'post',
                url: '/member/register',
                data: $('#registerForm').serialize(),
                success: function() {
                    alert('회원가입 완료');
                },
                error: function(e) {
                    console.log(e);
                }
            }); //ajax
        }
    });

})