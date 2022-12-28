<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>hello ${user.name}</h1>

<form method="get" action="${pageContext.request.contextPath}/logout">
    <input type="submit" value="logout">
</form>
<form method="get" action="${pageContext.request.contextPath}/secured/getUserList">
    <input hidden="true" value="${user.id}" name="id">
    <input type="submit" value="list of users">
</form>
</body>
</html>
