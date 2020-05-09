<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录页面</title>
    <!-- Bootstrap -->
    <link href="statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="statics/css/login.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="statics/js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="statics/js/bootstrap.min.js"></script>
    <script src="statics/js/login.js"></script>
</head>

<body>
<div class="page-container">
    <div class="layer"></div>

    <div class="empty-height-250">
        <div class="row header page-header header-font-size">
            <div class="glyphicon glyphicon-leaf col-sm-1 col-sm-offset-4 flag"></div>
            <div class="col-sm-5">走神博客系统</div>
        </div>
    </div>

    <div class="row header">
        <div class="col-sm-1 col-sm-offset-4 img-span"><img src="" class="img-circle glyphicon glyphicon-user"></div>
        <div class="col-sm-3  nav">请先登录或[<a href="${pageContext.request.contextPath}/register.jsp">注册</a>]</div>
    </div>


    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/user/login.do">

        <div class="form-group">
            <label for="username" class="col-sm-2 control-label col-sm-offset-2">用户名</label>
            <div class="col-sm-5">
                <input name="username" type="text" class="form-control" id="username" placeholder="输入用户名">
            </div>

            <div class="col-sm-3" id="userError"></div>
        </div>

        <div class="form-group">
            <label for="password" class="col-sm-2 control-label col-sm-offset-2">密码</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" id="password" placeholder="输入密码">
            </div>

            <div class="col-sm-3" id="pwdError"></div>
        </div>

        <div class="form-group">
            <label for="code" class="col-sm-2 control-label col-sm-offset-2">验证码</label>
            <div class="col-sm-2">
                <input type="text" class="form-control" id="code" placeholder="输入验证码">
            </div>

            <div class="col-sm-3"><img id="codeImg" src="${pageContext.request.contextPath}/user/code.do" alt=""></div>
        </div>

        <div class="col-sm-3 col-sm-offset-4" id="codeError"></div>

        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-10">
                <button type="submit" class="btn btn-default">登录</button>
            </div>
        </div>

    </form>

</div>
</div>

</body>
</html>
