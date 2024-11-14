/*
$(function () {

    $('#searchListBtn').click(function () {
        if ($('#columnValue').val() == '') {
            alert("검색어를 입력하세요")
        } else {
            $.ajax({
                type: 'get',
                url: '/member/search',
                data: {
                    'columnName': $('#columnName').val(),
                    'columnValue': $('#columnValue').val()
                },
                dataType: 'json',
                success: function (data) {
                    console.log(data);
                },
                error: function (e) {
                    console.log(e);
                }

            })
        }
    })

})
*/
