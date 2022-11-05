package taskServlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SetUserServlet", urlPatterns = "/SetUser.do")
public class SetUser extends HttpServlet{
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String name = req.getParameter("name");
        final String phone = req.getParameter("phone");
        final String email = req.getParameter("email");

        req.setAttribute("name", name);
        req.setAttribute("phone", phone);
        req.setAttribute("email", email);
        getServletContext().getRequestDispatcher("/jsp/showUser.jsp")
                .forward(req, resp);
    }

}
