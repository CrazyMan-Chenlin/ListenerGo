<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.10
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>用户登录页面</title>
</head>
<fmt:setBundle basename="message"/>
<body>
<h2 align="center">用户登录页面</h2>
<hr>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/LoginServlet">
        <span id="message" style="color: red">${message}</span><br>
        <fmt:message key="username"/>：<input name="username" type="text"/><br><br>
        <fmt:message key="password"/>：<input name="password" type="password"/><br><br>
        <input type="submit" value="<fmt:message key="SignIn"/>"/> &nbsp; &nbsp;<input type="button" onclick="register()" value="<fmt:message key="Register"/>"/>
    </form>
</div>
  <jsp:include page="footer.jsp"/>
</body>
<script type="text/javascript">
    function register() {
        window.open("${pageContext.request.contextPath}/register.jsp");
    }
</script>
</html>
