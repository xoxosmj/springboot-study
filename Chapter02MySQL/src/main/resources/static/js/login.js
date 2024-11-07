$('#loginBtn').click(function () {
    $('#idDiv').empty();
    $('#pwdDiv').empty();

    if ($('#id').val() == '') {
        $('#idDiv').html('아이디 입력');
        $('#id').focus();
    } else if ($('#pwd').val() == '') {
        $('#pwdDiv').html('비밀번호 입력');
        $('#pwd').focus();
    } else {
        $('#loginForm').submit();
    }
})