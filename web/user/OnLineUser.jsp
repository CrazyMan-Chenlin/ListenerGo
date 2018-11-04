<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.13
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>OnLineUser</title>
</head>
<body>
<h2 align="center">在线用户列表</h2>
<hr>
      <table border="1px" align="center">
          <tr>
              <th>编号</th>
              <th>登录名</th>
              <th>SessionID</th>
              <th>登录时间</th>
              <th>最后登陆时间</th>
              <th>IP</th>
              <th>操作</th>
          </tr>
          <c:forEach items="${applicationScope.onLineBeanList}" var="OnLineBean" varStatus="OnLineBeanStatus">
          <tr>
              <td>${OnLineBeanStatus.count}</td>
              <td>${OnLineBean.user.username}</td>
              <td>${OnLineBean.sessionId}</td>
              <td>${OnLineBean.loginTime}</td>
              <td>${OnLineBean.lastTime}</td>
              <td>${OnLineBean.ip}</td>
              <td><a href="${pageContext.request.contextPath}/KickOutServlet?sessionId=${OnLineBean.sessionId}">踢除</a> </td>
          </tr>
          </c:forEach>
      </table>
</body>
</html>
