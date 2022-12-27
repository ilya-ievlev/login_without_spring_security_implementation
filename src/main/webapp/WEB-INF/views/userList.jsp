<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list of users</title>
</head>
<body>
<c:forEach var="user" items="${userList}">
    username: <c:out value="${user.name}"/> <br>
    login: <c:out value="${user.userLogin}"/><br>
    ================================<br>
</c:forEach>

<form method="get" action="${pageContext.request.contextPath}/secured/helloLoggedUser">
    <input hidden="true" value="${user.userId}" name="id">
    <input type="submit" value="return">
</form>
</body>
</html>
