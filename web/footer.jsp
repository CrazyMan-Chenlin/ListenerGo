<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.14
  Time: 16:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
    <title>footer页面</title>
</head>
<body>
<%
    /**
     * 参数一： 日期格式.  short  medium long  full
     * 参数二：时间格式 .  short  medium long  full
     * 参数三：国家的locale
     */
%>
<jsp:useBean id="now" class="java.util.Date" />
   <div style="position: fixed;bottom:0;left:40%;width: 100%;height:4%" >
        <fmt:formatDate value="${pageScope.now}" dateStyle="full" />
   </div>
</body>
</html>
