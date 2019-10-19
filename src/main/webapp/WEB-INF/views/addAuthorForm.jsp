<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

</head>
<body>
<form:form method="post" modelAttribute="author">

    <label for="firstNameId">First Name:</label>
    <form:input type="text" path="firstName" id="firstNameId"/>
    <form:errors path="firstName" />

    <br/><br/>

    <label for="lastNameId">Last Name:</label>
    <form:input path="lastName" id="lastNameId"/>
    <form:errors path="lastName" />

    <br/><br/>

    <label for="yearOfBirthId">Year of birth:</label>
    <form:input path="yearOfBirth" id="yearOfBirthId"/>
    <form:errors path="yearOfBirth" />

    <input type="submit" value="Save">
</form:form>
</body>
</html>
