import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import servlets.MainServlet;
import servlets.MarketServlet;
import servlets.UserDataServlet;
import servlets.WorkingGroupServlet;

/**
 * Created by iters on 3/2/17.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.addServlet(new ServletHolder(new MainServlet()), "/");
        context.addServlet(new ServletHolder(new WorkingGroupServlet()), "/workingGroup");
        context.addServlet(new ServletHolder(new UserDataServlet()), "/user_data");
        context.addServlet(new ServletHolder(new MarketServlet()), "/market");

        Server server = new Server(8000);
        server.setHandler(context);

        server.start();
        server.join();
    }
}