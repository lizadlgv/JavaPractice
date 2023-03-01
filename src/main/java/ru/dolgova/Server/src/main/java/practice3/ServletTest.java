package practice3;

import ru.dolgova.practice2.ApplicationDataSource;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet("/table")
public class ServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try (PrintWriter out = resp.getWriter()) {
            Statement statement = ApplicationDataSource.getConnection().createStatement();
            ResultSet set = statement.executeQuery("select * from directorTab join filmTab on directorTab.directorid = filmTab.directorid;");
            createTable(set, out);
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(ResultSet set, PrintWriter out) throws SQLException {
        out.println("<HTML><BODY>");
        if (set.next()) {
            out.print("<table><tr><th>directorid</th><th>name</th><th>secondname</th><th>bday</th><th>sex</th><th>id</th><th>title</th><th>rating</th></tr>");
            do {
                out.print("<tr>");
                out.print("<td>" + set.getObject("directorid") + "</td>");
                out.print("<td>" + set.getObject("name") + "</td>");
                out.print("<td>" + set.getObject("secondname") + "</td>");
                out.print("<td>" + set.getObject("bday") + "</td>");
                out.print("<td>" + set.getObject("sex") + "</td>");
                out.print("<td>" + set.getObject("id") + "</td>");
                out.print("<td>" + set.getObject("title") + "</td>");
                out.print("<td>" + set.getObject("rating") + "</td>");
                out.print("</tr>");
            } while (set.next());
            out.print("</table>");
        }
        out.println("</BODY></HTML>");
    }
}
