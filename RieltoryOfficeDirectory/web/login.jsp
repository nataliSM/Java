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
    <title>LoginServlet</title>
</head>
<body>

<center>
<form action="./login" method="post">

  Enter username :  <input type="text" name="username" size=15 type="text" /> <br>
    Enter password :  <input type="password" name="password" size=15 type="text" /> <br>
    <input type="submit" value = "Login">
    </table>
</form>


<form action="./registration" method="get">
    <input type="submit" value="Registration">
</form>
</center>



</body>
</html>
