<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="practice4.SelectReq" %>
<html>
<head>
  <title>Director</title>
</head>
<body>
<h1>Table Director</h1>
<table>
        <tHead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Second Name</th>
                <th>BDay</th>
                <th>Sex</th>
            </tr>
        </tHead>

        <%
        SelectReq director = (SelectReq) request.getAttribute("directorTab");
        %>
        <tr>
        <td style="text-align:center"> <%= director.getIdDirector() %> </td>
        <td style="text-align:center"> <%= director.getName() %> </td>
        <td style="text-align:center"> <%= director.getSecondName() %> </td>
        <td style="text-align:center"> <%= director.getBDay() %> </td>
        <td style="text-align:center"> <%= director.getSex() %> </td>
        <tr>
</table>
</body>
</html>