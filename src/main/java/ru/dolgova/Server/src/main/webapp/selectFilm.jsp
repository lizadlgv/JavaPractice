
<%@ page import="java.util.*"%>
<%@ page import="practice4.SelectReq" %>
<html>
<head>
  <title>Film</title>
</head>
<body>
<h1>Film</h1>
<table>
        <tHead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Rating</th>
                <th>ID director</th>
            </tr>
        </tHead>

        <%
        SelectReq film = (SelectReq) request.getAttribute("filmTab");
        %>
        <tr>
        <td style="text-align:center"> <%= film.getIdFilm() %> </td>
        <td style="text-align:center"> <%= film.getTitle() %> </td>
        <td style="text-align:center"> <%= film.getRating() %> </td>
        <td style="text-align:center"> <%= film.getIdDirector() %> </td>
        <tr>
</table>
</body>
</html>