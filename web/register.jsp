<%--
  Created by IntelliJ IDEA.
  User: chenlin
  Date: 2018.10.10
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>
<h2 align="center">用户注册页面</h2>
<hr>
<div align="center">
    <form method="post" action="${pageContext.request.contextPath}/RegisterServlet" onsubmit=" return checkPassword()">

        <span id="message"></span> <br>
        请输入手机号码：<input name="username" type="text"/><br><br>
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;请输入密码：<input name="password" id="password1" type="password"/><br><br>
        &nbsp;&nbsp;&nbsp;请再输入密码：<input id="password2" type="password" onblur="checkPassword()"/>
        <br><br>
        <input type="submit" value="完成注册"/> &nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/login.jsp">回到登录页面</a>
    </form>
</div>
<jsp:include page="footer.jsp"/>
</body>
<script type="text/javascript">
    function checkPassword() {
        var password1 = document.getElementById("password1").value;
        var password2 = document.getElementById("password2").value;
        if(password1!=""&&password2!=""){
            if(password1!=password2){
                document.getElementById("message").innerHTML="<font color='red'>*两次密码输入不一致，请重新输入！</font>"
                return false;
            }else{
                document.getElementById("message").innerHTML="<font color='green'>*两次密码相同！</font>"
                return true;
            }
        }

    }
</script>
</html>
