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
        function confirmDelete(id, name) {
            if (confirm("Czy na pewno usunąć wydawcę \"" + name + "\"")) {
                window.location.href = "/publisher/delete/" + id;
            }
        }
    </script>
</head>
<body>
<table>
    <tr>
        <th>Name</th>
        <th>NIP</th>
        <th>REGON</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="publisher" items="${publishers}">
        <tr>
            <td>${publisher.name}</td>
            <td>${publisher.nip}</td>
            <td>${publisher.regon}</td>
            <td><a href="/publisher/editForm/${publisher.id}">edit</a></td>
            <td><a href="#" onclick="confirmDelete(${publisher.id}, '${publisher.name}')">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>