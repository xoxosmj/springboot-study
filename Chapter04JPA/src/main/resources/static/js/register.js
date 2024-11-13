$(function (){
    $('#registerBtn').click(function () {
        $('#idDiv').empty();
        $('#pwdDiv').empty();
        $('#nameDiv').empty();

        if ($('#id').val() == '') {
            $('#idDiv').text('아이디 입력');
            $('#id').focus();
        }

        else if ($('#pwd').val() == '') {
            $('#pwdDiv').text('비밀번호 입력');
            $('#pwd').focus();
        }

        else if ($('#name').val() == '') {
            $('#nameDiv').text('이름 입력');
            $('#name').focus();
        }else {
            $.ajax({}); //ajax
        }
    });

})