<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.9
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <title>business.front.index.web.index.index</title>
  </head>
  <%--国家化日期操作--%>
  <fmt:setBundle basename="message"/>
  <body>
   <%--您是第${applicationScope.count}个访客<br>
   您的ip是${sessionScope.ip}--%>
   <div style="text-align: right">
       <c:choose>
           <c:when test="${empty sessionScope.user}">
               <a href="${pageContext.request.contextPath}/login.jsp"><fmt:message key="SignIn"/> </a>&nbsp;&nbsp;
               <a href="${pageContext.request.contextPath}/register.jsp"><fmt:message key="Register"/></a>
           </c:when>
           <c:otherwise>
               welcome,${sessionScope.user.username}&nbsp;&nbsp;
               <a href="${pageContext.request.contextPath}/LoginOutServlet">SignOut</a><br>
               <a href="${pageContext.request.contextPath}/OnLineServlet">[Watch OnlineUser]</a>
           </c:otherwise>
       </c:choose>
   </div>
   <jsp:include page="footer.jsp"/>
  </body>

</html>
