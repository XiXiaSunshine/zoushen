$(function () {
    let $username = $('#username');
    let $pwd = $('#password');
    let $pwdAgain = $('#pwdAgain');
    let useName = false;

    // 登录按钮提交控制
    onsubmit = function (use) {
        use = useName;
        console.log(use);
        return checkUsername() && checkPwd() && checkAgainPwd() && use;
    }

    $username.change(function () {
        if ($username.val() == "") {
            checkUsername();
        }else{
            checkUsernameOnServer();
        }
    })

    $pwd.blur(function () {
        checkPwd();
    });

    $pwdAgain.blur(function () {
        checkAgainPwd();
    });

    function checkUsernameOnServer() {
        $.get(
            "/zoushen/user/checkName.do?username=" + $username.val(),
            function (resp) {
                if (resp.code == 2001){
                    $('#userError').html(resp.msg).css("color", "#74FF00").show();
                    useName = true;
                }else {
                    $('#userError').html(resp.msg).css("color", "red").show();
                }
            }
        );
    }

    function checkUsername() {

        if ($username.val() != "") {
            $('#userError').hide();
            return true;
        }else {
            $('#userError').html("用户名不能为空！").css("color", "red").show();
            return false;
        }
    }

    function checkPwd() {

        if ($pwd.val() != "") {
            $('#pwdError').hide()
            return true;
        }
        $('#pwdError').html("密码不能为空！").css("color", "red").show();

        return false;
    }

    function checkAgainPwd() {
        console
        if ($pwdAgain.val() == $pwd.val()) {
            $('#pwdAgainError').hide();
            return true;
        }
        $('#pwdAgainError').html("两次密码不一致").css("color", "red").show();

        return false;
    }
})