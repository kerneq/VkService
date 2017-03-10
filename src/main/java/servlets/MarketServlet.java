package servlets;

import dataHandler.PostHandlerSystem;
import dataHandler.PostInfo;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by iters on 3/8/17.
 */
public class MarketServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<PostInfo> photos = new PostHandlerSystem("/home/iters/media/").getImagesByPath();
        Map<String, Object> map = new HashMap<>();
        map.put("list", photos);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().print(PageGenerator.instance().getPage("page.html", map));
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
