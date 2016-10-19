<%--
  Created by IntelliJ IDEA.
  User: Natalia
  Date: 09.10.16
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>

ПРИВЕТ
<%
String username = null;
    if(session.getAttribute("username") == null){
        response.sendRedirect("/login.jsp");
    }else username = (String) session.getAttribute("username");
    String userName = null;
    String sessionID = null;
    Cookie[] cookies = request.getCookies();
    if(cookies !=null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("username")) userName = cookie.getValue();
            //if (cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
        }
    }else{
        sessionID = session.getId();
    }



    %>


<form action="LogoutServlet" method="post">
    <input type="submit" value="Logout" >
    </form>
</body>
</html>
