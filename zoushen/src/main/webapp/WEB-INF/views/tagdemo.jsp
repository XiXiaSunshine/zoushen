<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yang
  Date: 2020/5/7
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/statics/js/jquery-3.4.1.min.js"></script>
</head>

<script>
    onsubmit = function () {
        $.post(
            "${pageContext.request.contextPath}/test/test.do",
            {"a":"aaa","bbb":1},
            function (data) {
                console.log(data);
            }

        )
        return false;
    }
</script>
<body>
<form action="">
    <sf:label path="username" cssErrorClass="error">username</sf:label>:
    <sf:input path="username" cssErrorClass="error" name="usename"></sf:input>
    <button type="submit">请求</button>
</form>

</body>
</html>
