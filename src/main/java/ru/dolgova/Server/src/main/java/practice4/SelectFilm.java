package practice4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/selectFilm")
public class SelectFilm extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        var film = new SelectReq("null","null","null","null");
        req.setAttribute("filmTab", film);
        getServletContext().getRequestDispatcher("/selectFilm.jsp").forward(req, resp);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String id = request.getParameter("id");
        System.out.println(id);
        try {
            SelectReq film = new Find().findFilm(id);
            request.setAttribute("filmTab", film);
            getServletContext().getRequestDispatcher("/selectFilm.jsp").forward(request, response);
        } catch (Exception exception) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
            throw new RuntimeException(exception.getMessage());
        }
    }
}
