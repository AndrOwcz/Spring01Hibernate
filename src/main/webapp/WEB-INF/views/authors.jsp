<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script>
        function confirmDelete(id, firstName, lastName) {
            if (confirm("Czy na pewno usunąć autora \"" + firstName + " " + lastName + "\"")) {
                window.location.href = "/author/delete/" + id;
            }
        }
    </script>
</head>
<body>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
<%--        <th>Email</th>--%>
<%--        <th>PESEL</th>--%>
        <th>Year of birth</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="author" items="${authors}">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
<%--            <td>${author.email}</td>--%>
<%--            <td>${author.pesel}</td>--%>
            <td>${author.yearOfBirth}</td>
            <td><a href="/author/editForm/${author.id}">edit</a></td>
            <td><a href="#" onclick="confirmDelete(${author.id}, '${author.firstName}', '${author.lastName}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>