package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by iters on 3/8/17.
 */
public class UserDataServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String group_url = req.getParameter("my_group");
        resp.sendRedirect("/market");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}