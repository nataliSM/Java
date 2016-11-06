<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 09.10.16
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<form action="/home" method="post">
    <select name="numberOfRooms">
        <option value="1">1 комната</option>
        <option value="2">2 комнаты</option>
        <option value="3">3 комнаты</option>
    </select>

    <select name="repair">
        <option value="есть">Есть</option>
        <option value="нет">Нет</option>
    </select>

    <select name="condition">
        <option value="хорошее">Хорошее</option>
    </select>

    <select name="city">
        <option value="Казань">Казань</option>
        <option value="Москва">Москва</option>
        <option value="Санкт-Петербург">Санкт-Петербург</option>
    </select>

    <br><br>
    <input type="submit">
</form>


</body>
</html>