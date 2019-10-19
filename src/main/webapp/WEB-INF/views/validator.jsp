<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="violation" items="${violations}">

    ${violation.propertyPath} : ${violation.message}
    <br>
</c:forEach>
<br><br>
<c:forEach var="error" items="${customErrors}">

    ${error.name} : ${error.reason}
    <br>
</c:forEach>

</body>
</html>