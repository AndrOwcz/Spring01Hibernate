<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    Title: <form:input type="text" path="title"/>
    <form:errors path="title" cssClass="error"/><br>
    Rating: <form:input type="number" path="rating"/>
    <form:errors path="rating" cssClass="error"/><br>
    Description: <form:input type="text" path="description"/><br>
    <form:errors path="description" cssClass="error"/> <br>
    <label>Publisher:</label>
    <form:select path="publisher.id" itemValue="id" itemLabel="name" items="${publishers}"/>
    <br>
    <form:errors path="publisher.id" cssClass="error"/> <br>
    <label>Author:</label>
    <form:select path="authors" itemValue="id" itemLabel="fullName" items="${authors}"/>
    <br>
    <form:errors path="authors" cssClass="error"/> <br>
    <input type="submit" value="Submit">
</form:form>
</body>
</html>
