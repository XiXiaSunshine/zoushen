<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  UserInfo: yang
  Date: 2020/4/30
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${msg}</title>
    <style>
        .container-page{
            margin: 0 auto;
            padding: 0;
            width: 800px;
            background-color: #eeeeee;
        }
    </style>
</head>
<body>
<div class="container-page">
    <h1>${msg}</h1>
    <a href="${pageContext.request.contextPath}/<c:if test="${not empty url}">${url}</c:if>">请点击返回</a>
</div>
</body>
</html>
