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
            if (confirm("Czy na pewno usunąć książkę \"" + title + "\"")) {
                window.location.href = "/book/delete/" + id;
            }
        }
    </script>
</head>
<body>
<div class="container-fluid">

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
    <c:forEach var="book" items="${books}">
            <td>${book.title}</td>
            <td>${book.rating}</td>
            <td>${book.publisher.name}</td>
            <td>${book.description}</td>
            <td>${book.proposition}</td>
            <td><a href="/book/editForm/${book.id}">edit</a></td>
            <td><a href="#" onclick="confirmDelete(${book.id}, '${book.title}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
</div>
</body>
</html>