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
        function confirmDelete(id, title) {
            if (confirm("Czy na pewno usunąć propozycję \"" + title + "\"")) {
                window.location.href = "/proposition/delete/" + id;
            }
        }
    </script>
</head>
<body>
<table>
    <tr>
        <th>Title</th>
        <th>Rating</th>
        <th>Publisher</th>
        <th>Description</th>
        <th>Propositions</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="proposition" items="${propositions}">
        <tr>
            <td>${proposition.title}</td>
            <td>${proposition.rating}</td>
            <td>${proposition.publisher.name}</td>
            <td>${proposition.description}</td>
            <td>${proposition.proposition}</td>
            <td><a href="/proposition/editForm/${proposition.id}">edit</a></td>
            <td><a href="#" onclick="confirmDelete(${proposition.id}, '${proposition.title}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>