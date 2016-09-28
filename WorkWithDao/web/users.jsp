<%@ page language="java" contentType="text/html; charset=US-ASCII"
         pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
    <title>Home Page</title>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</head>
<body>
<%-- Using JSTL forEach and out to loop a list and display items in table --%>
<table>
    <tbody>
    <c:forEach var="user" items="${userList">
        <p>${user}</p>
    </c:forEach>
    </tbody>
</table>

</body>
</html>