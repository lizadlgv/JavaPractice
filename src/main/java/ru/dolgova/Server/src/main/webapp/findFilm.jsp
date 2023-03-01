<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="practice4.SelectReq" %>
<html>
<head>
  <title>Film</title>
</head>
<body>
<form action = "selectFilm" method="post">
       <input type="text" name="id" placeholder="Введите id" size="18" /><br><br>
       <input type="submit" value="Find!" />
</form>
</body>
</html>