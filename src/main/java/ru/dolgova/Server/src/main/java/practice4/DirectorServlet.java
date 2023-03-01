package practice4;

import ru.dolgova.practice2.command.executor.DirectorCreate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static ru.dolgova.practice2.command.executor.DirectorCreate.createDirector;
import static ru.dolgova.practice2.command.executor.DirectorRemove.removeDirector;

@WebServlet("/director")
public class DirectorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if (req.getParameterMap().size() == 5) {
            getServletContext().getRequestDispatcher("/CreateDirector.jsp").forward(req, resp);
        }
        if (req.getParameterMap().size() == 1) {
            getServletContext().getRequestDispatcher("/RemoveDirector.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            if (req.getParameterMap().size() == 5) {
                String directorID = req.getParameter("directorId");
                String name = req.getParameter("name");
                String secondName = req.getParameter("secondName");
                String BDay = req.getParameter("BDay");
                String sex = req.getParameter("sex");
                createDirector("create " + directorID + " " + name + " " + secondName + " " + BDay + " " + sex);
                resp.sendRedirect(req.getContextPath());
            }
            if (req.getParameterMap().size() == 1) {
                String directorID = req.getParameter("directorId");
                int i = removeDirector("remove " + directorID);
                if (i != 1) {
                    throw new RuntimeException("Check the correctness of the director ID");
                }
                resp.sendRedirect(req.getContextPath());
            }
        } catch (Exception exception) {
            getServletContext().getRequestDispatcher("/error.jsp").forward(req, resp);
            throw new RuntimeException(exception.getMessage());
        }
    }
}
