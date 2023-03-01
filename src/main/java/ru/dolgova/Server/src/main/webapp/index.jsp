<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="practice4.SelectReq"%>
<html>
<form>
<head>
    <title>Start Page</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false"%>
</head>
<body>
<div style="font-size: 20px; padding: 30px; margin: 50px; border: 1px solid black; border-radius: 5px; display: flex; flex-direction: column; justify-content: center;">
<ur>
<%
    String[] commands = new String[] {"CreateDirector"," CreateFilm", "RemoveFilm","RemoveDirector", "findFilm", "findDirector"};
    request.setAttribute("urls", commands);
%>
<div style="text-align: center;">
      <c:forEach var = "url" items="${urls}">
            <a href="<c:url value='  ${url}.jsp  ' />"><strong>${url}</strong></a>
      </c:forEach>
</div>
</ur>
<%
    List<SelectReq> selectReq = (List) request.getAttribute("selectReq");
%>
<div style="text-align: center;">
<table style="display: inline-block;  font-size: 20px;">
    <thead>
    <tr>
        <th>ID director</th>
        <th>Name</th>
        <th>Second Name</th>
        <th>BDay</th>
        <th>Sex</th>
        <th>ID film</th>
        <th>Title</th>
        <th>Rating</th>
    </tr>
    </thead>
    <tbody>
          <% for(SelectReq sel : selectReq) { %>
             <tr>
                <td style="text-align:center"> <%= sel.getIdDirector() %> </td>
                <td style="text-align:center"> <%= sel.getName() %> </td>
                <td style="text-align:center"> <%= sel.getSecondName() %> </td>
                <td style="text-align:center"> <%= sel.getBDay() %> </td>
                <td style="text-align:center"> <%= sel.getSex() %> </td>
                <td style="text-align:center"> <%= sel.getIdFilm() %> </td>
                <td style="text-align:center"> <%= sel.getTitle() %> </td>
                <td style="text-align:center"> <%= sel.getRating() %> </td>
             <tr>
          <% } %>
    </tbody>
</table>
</div>
</div>
</body>
</form>
</html>