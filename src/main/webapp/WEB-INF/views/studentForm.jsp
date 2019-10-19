<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Simple Student Form</title>
<%--</head>--%>
<%--<body>--%>

<%--<form:form method="post" modelAttribute="student">--%>
<%--    First Name: <form:input path="firstName"/> <br>--%>
<%--    Last Name: <form:input path="lastName"/><br/>--%>
<%--    Gender:--%>
<%--    Male: <form:radiobutton path="gender" value="M"/>--%>
<%--    Female: <form:radiobutton path="gender" value="F"/><br/>--%>
<%--    Country: <form:select path="country" items="${countries}"/><br/>--%>
<%--    Notes: <form:textarea path="notes" rows="3" cols="20"/><br/>--%>
<%--    Add to mailing list? <form:checkbox path="mailingList"/><br/>--%>
<%--    Programming skills: <form:select path="programmingSkills" items="${programmingSkills}" multiple="true"/><br/>--%>
<%--    Hobbies: <form:checkboxes items="${hobbies}" path="hobbies"/><br/>--%>

<%--    <input type="submit" value="Save">--%>
<%--</form:form>--%>

<%--</body>--%>
<%--</html>--%>

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="form-group">
</div>
<div class="container-fluid">
    <form:form method="post" modelAttribute="student">
        <label for="firstNameId">First Name:</label>
        <form:input class="form-control" type="text" path="firstName" id="firstNameId"/>
        <br/>
        <label for="lastNameId">Last Name:</label>
        <form:input class="form-control" type="text" path="lastName" id="lastNameId"/>
        <br/>
        <label>Gender:</label>
        Male: <form:radiobutton path="gender" value="M"/>
        Female: <form:radiobutton path="gender" value="F"/>
        <br/>
        <label>Country:</label>
        <form:select class="form-control" path="country">
            <form:option value="-" label="--Please Select--"/>
            <form:options items="${countries}"/>
        </form:select>
        <br/>
        <label>Mailing list:</label>
        <form:checkbox path="mailingList"/>
        </br>
        <label>Notes:</label>
        <form:textarea class="form-control" path="notes" id="notesId"/>
        <br/>
        <label>Programming Skills:</label>
        <form:select class="form-control" path="programmingSkills" items="${programmingSkills}" multiple="true"/>
        <br/>
        <label>Hobbies:</label>
        <form:checkboxes items="${hobbies}" path="hobbies"/>
        <br/>
        <input type="submit" class="btn btn-primary" value="Save">
    </form:form>
</div>
</body>
</html>
