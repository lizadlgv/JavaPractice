package practice4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.dolgova.practice2.command.executor.FilmCreate.createFilm;
import static ru.dolgova.practice2.command.executor.FilmRemove.removeFilm;

@WebServlet("/film")
public class FilmServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameterMap().size() == 4) {
            getServletContext().getRequestDispatcher("/CreateFilm.jsp").forward(req, resp);
        }
        if (req.getParameterMap().size() == 1) {
            getServletContext().getRequestDispatcher("/RemoveFilm.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameterMap().size() == 4) {
                String id = req.getParameter("id");
                String title = req.getParameter("title");
                String rating = req.getParameter("rating");
                String directorID = req.getParameter("directorId");
                createFilm("create " + id + " " + title + " " + rating + " " + directorID);
                resp.sendRedirect(req.getContextPath());
            }
            if (req.getParameterMap().size() == 1) {
                String id = req.getParameter("id");
                int i = removeFilm("remove " + id);
                if (i != 1) {
                    throw new RuntimeException("Check the correctness of the film ID");
                }
                resp.sendRedirect(req.getContextPath());
            }
        } catch (Exception exception) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            throw new RuntimeException(exception.getMessage());
        }
    }
}
