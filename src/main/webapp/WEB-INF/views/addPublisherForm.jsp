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
<form:form method="post" modelAttribute="publisher">

    <label for="nameId">Name:</label>
    <form:input type="text" path="name" id="nameId"/>
    <form:errors path="name" />

    <br/><br/>

<%--    <label for="nipId">NIP:</label>--%>
<%--    <form:input path="nip" id="nipId"/>--%>
<%--    <form:errors path="nip" />--%>

<%--    <br/><br/>--%>

<%--    <label for="regonId">REGON:</label>--%>
<%--    <form:input path="regon" id="regonId"/>--%>
<%--    <form:errors path="regon" />--%>

    <input type="submit" value="Save">
</form:form>
</body>
</html>
