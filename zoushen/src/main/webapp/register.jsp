<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/4/30
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
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
    <script src="statics/js/register.js"></script>
</head>
<body>
<div class="page-container">
    <div class="empty-height-120">
        <div class="row header">
            <a class="glyphicon glyphicon-arrow-left back" href="${pageContext.request.contextPath}/index.jsp">返回登录</a>
        </div>
    </div>

    <div class="row header">
        <div class="col-sm-2 col-sm-offset-5">用户注册</div>
    </div>

    <form class="form-horizontal" action="${pageContext.request.contextPath}/user/regist.do" method="post">

        <div class="form-group">
            <label for="username" class="control-label col-sm-2 col-sm-offset-2">用户名</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="username" id="username"/>
            </div>

            <div class="col-sm-3" id="userError"></div>
        </div>

        <div class="form-group">
            <label for="sex" class="control-label col-sm-2 col-sm-offset-2">性别</label>
                <div class="col-sm-2">
                <div class="radio" id="sex">
                    <label>
                        <input type="radio" value="1" name="sex" id="male" checked="checked"/>男
                    </label>
                    <label>
                        <input type="radio" value="0" name="sex" id="female"/>女
                    </label>

                    <div class="col-sm-3" id="sexError"></div>
                </div>
            </div>
        </div>

        <div class="form-group">
            <label for="email" class="control-label col-sm-2 col-sm-offset-2">邮箱</label>
            <div class="col-sm-5">
                <input type="email" class="form-control" name="email" id="email"/>
            </div>

            <div class="col-sm-3" id="emailError"></div>
        </div>

        <div class="form-group">
            <label for="birthday" class="control-label col-sm-2 col-sm-offset-2">出生日期</label>
            <div class="col-sm-5">
                <input type="date" class="form-control" name="birthday" id="birthday" value="2020-01-01"/>
            </div>

            <div class="col-sm-3" id="birthError"></div>
        </div>

        <div class="form-group">
            <label for="password" class="control-label col-sm-2 col-sm-offset-2">密码</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="password" id="password"/>
            </div>
            <div class="col-sm-3" id="pwdError"></div>
        </div>

        <div class="form-group">
            <label for="pwdAgain" class="control-label col-sm-2 col-sm-offset-2">确认密码</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="pwdAgain"/>
            </div>
            <div class="col-sm-3" id="pwdAgainError"></div>
        </div>


        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-10">
                <button type="submit" class="btn btn-default">立即注册</button>
            </div>
        </div>

    </form>
</div>

</body>
</html>
