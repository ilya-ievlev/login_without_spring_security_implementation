<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1> please login/register new user</h1>
<form method="post" action="${pageContext.request.contextPath}/login">
    login: <input type="text" name="login" value="${user.userLogin}" placeHolder="enter login here"
                  size="60"><br><br>
    password: <input type="password" name="password" value="${user.userPassword}" placeholder="enter password here"
                     size="60"><br><br>
    <c:if test="${dataNotCorrect eq true}">
        <font color="#dc143c">error</font><br>
    </c:if>
    <input type="submit" value="login">
</form>
</body>
</html>
