<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/4/30
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>用户主页</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/statics/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/css/login.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/statics/css/main.css" rel="stylesheet">
    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="${pageContext.request.contextPath}/statics/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/statics/js/main.js"></script>
</head>
<body>
<div class="container-fluid">

    <div class="row page">

        <div class="left-area col-md-2">
            <div class="row notes">

                <div class="row left-head">
                    <div class="col-md-4 col-md-offset-3 notes-label">笔记</div>
                    <div class="col-md-5 more-line"><a href="#">>>更多</a></div>
                </div>

                <div class="row notes-body"></div>

            </div>

            <div class="row system-msg">
                <div class="row left-head">
                    <div class="col-md-4 col-md-offset-3 notes-label">公告</div>
                    <div class="col-md-5  more-line"><a href="#">>>更多</a></div>
                </div>
                <div class="row"></div>
            </div>
        </div>

        <div class="center-area col-md-8">

            <div class="row center-head">

                <div class="col-md-2 grade-info row">
                    <div class="row level">等级：${userInfo.level}(距离升级还需：${userInfo.nextExperience-userInfo.experience})</div>

                    <div class="row experience-details">
                        <div class="progress">
                            <div class="progress-bar progress-bar-success" role="progressbar"
                                 aria-valuenow="${userInfo.experience/userInfo.nextExperience*100}" aria-valuemin="0" aria-valuemax="100" style="width: ${userInfo.experience/userInfo.nextExperience*100}%">
                                ${userInfo.experience}_EXP
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-4 col-md-offset-2 user-label">${userInfo.username}博客</div>

                <div class="col-md-4 row info-bar">

                    <div class="col-md-5 col-md-offset-4 create-article">
                        <div class="btn-group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown"
                                    aria-haspopup="true" aria-expanded="false"> 开始创作 <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                                <li><a href="#">发博文</a></li>
                                <li><a href="#">写笔记</a></li>
                            </ul>
                        </div>
                    </div>

                    <div class="col-md-3  user-head">

                        <div class="dropdown">
                            <button class="btn btn-default dropdown-toggle btn-size-small" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                <img class="img-circle head-img" src="${pageContext.request.contextPath}/statics/image/${userInfo.headImg}" alt="头像">
                            </button>
                            <ul class="dropdown-menu zoushen-opacity-7-bg" aria-labelledby="dropdownMenu1">
                                <li><a href="${pageContext.request.contextPath}/user/info.do?username=${userInfo.username}" target="_blank">个人信息</a></li>
                                <li><a href="#" target="_blank">消息</a></li>
                                <li><a href="#" target="_blank">收藏</a></li>
                                <li><a href="#" target="_blank">关注</a></li>
                                <li><a href="#" target="_blank">反馈</a></li>
                                <li role="separator" class="divider"></li>
                                <li><a href="${pageContext.request.contextPath}/user/logout.do">退出</a></li>
                            </ul>
                        </div>

                    </div>
                </div>

            </div>

            <div class="row center-body">

                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Panel title</h3>
                    </div>
                    <div class="panel-body">
                        Panel content
                    </div>
                </div>

            </div>

        </div>

        <div class="right-area col-md-2">

            <div class="row blog-menu">

                <div class="row right-head">
                    <div class="col-md-6 col-md-offset-1 blog-menu-label">博文目录</div>
                    <div class="col-md-5 more-line"><a href="#">>>更多</a></div>
                </div>

                <div class="row blog-menu-body"></div>

            </div>

        </div>

    </div>

</div>


</body>
</html>