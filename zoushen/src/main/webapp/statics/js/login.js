$(function () {
    let $username = $('#username');
    let $pwd = $('#password');
    let $code = $('#code');

// 验证码点击
    $("#codeImg").click(function () {
        $(this).prop("src", "/zoushen/user/code.do?time=" + new Date().getTime())
    });

// 登录提交控制
    onsubmit = function () {
        checkCode();
        checkUsername();
        checkPwd();
        checkCodeOnServer();
        return false;
    }

    function checkCodeOnServer() {
        $.post(
            "/zoushen/user/check.do",
            {"username": $username.val(), "password": $pwd.val(), "code": $code.val()},
            function (resp) {
                if (resp.code == 1001) {
                    window.location.href = resp.data + "?username=" + $username.val();
                } else if (resp.code == 1002) {
                    $('#codeError').html(resp.msg).css("color", "red").show();
                } else if (resp.code == 1003) {
                    $('#pwdError').html(resp.msg).css("color", "red").show();
                } else if (resp.code == 1004) {
                    $('#userError').html(resp.msg).css("color", "red").show();
                }
            }
        );
    }

    $username.blur(function () {
        checkUsername()
    });

    $pwd.blur(function () {
        checkPwd();
    });

    $code.blur(function () {
        checkCode();
    });

    function checkUsername() {

        if ($username.val() != "") {
            $('#userError').hide();
            return true;
        }
        $('#userError').html("用户名不能为空！").css("color", "red").show();
        return false;
    }

    function checkPwd() {

        if ($pwd.val() != "") {
            $('#pwdError').hide()
            return true;
        }
        $('#pwdError').html("密码不能为空！").css("color", "red").show();

        return false;
    }

    function checkCode() {

        if ($code.val() != "") {
            $('#codeError').hide();
            return true;
        }
        $('#codeError').html("验证码不能为空！").css("color", "red").show();

        return false;
    }
})


