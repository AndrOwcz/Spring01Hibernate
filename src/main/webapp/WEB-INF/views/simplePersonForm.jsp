<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Simple Person Form</title>
</head>
<body>
<%--<form method="post">
    Login: <input type="text" name="login"><br>
    Password: <input type="password" name="password"><br>
    Email: <input type="email" name="email"><br>
    <input type="submit" value="Submit">
</form>--%>

<form:form method="post" modelAttribute="person">
    Login: <form:input path="login" />
    Password: <form:input type="password" path="password" />
    Email: <form:input path="email" />

    <input type="submit" value="Save">
</form:form>

</body>
</html>
