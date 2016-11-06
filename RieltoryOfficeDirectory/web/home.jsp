<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 09.10.16
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%@ page language="java" contentType="text/html; charset=cp1251" pageEncoding="cp1251"%>
<html>
<head>
 <link rel="stylesheet" href="style/bootstrap.min.css">
    <link rel="stylesheet" href="style/homeStyle.css">
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>

        <meta http-equiv="content-type" content="text/html; charset=cp1251">
    <title>Home Page</title>
    <style>
        table,th,td{
            border: 1px solid black;
        }
    </style>
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
<div class="offerce_table">
<table id="offer_table" class="table table-striped table-bordered">
    <thead>

    <tr><th>№</th><th>Город</th><th>Улица</th><th>Дом</th><th>Кв</th><th>Комнаты</th><th>Состояние квартиры</th><th>Ремонт</th>
        <th>Стоимость</th><th>ФИО риелтора</th><th>Контактный телефон</th>

    </thead>
        <tbody>
        <c:forEach items="${requestScope.offerList}" var="offer">
    <tr><td><c:out value="${offer.id}"></c:out></td>
        <td><c:out value="${offer.address.city.name}"></c:out></td>
        <td><c:out value="${offer.address.street.name}"></c:out></td>
        <td><c:out value="${offer.address.house}"></c:out></td>
        <td><c:out value="${offer.address.flat}"></c:out></td>
        <td><c:out value="${offer.feature.countOfRoom}"></c:out></td>
        <td><c:out value="${offer.feature.condition}"></c:out></td>
        <td><c:out value="${offer.feature.repair}"></c:out></td>
        <td><c:out value="${offer.cost}"></c:out></td>
        <td><c:out value="${offer.trader.name}"></c:out></td>
        <td><c:out value="${offer.trader.phoneNumber}"></c:out></td>
        </c:forEach>
    </tbody>
</table>
</div>
</body>
</html>