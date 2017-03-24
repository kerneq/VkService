package db;

import db.dao.PostDAO;
import db.dataSets.PostDataSet;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by iters on 3/24/17.
 */
public class DBService {
    private Connection connection;
    private PostDAO dao;
    public static DBService service;

    private DBService() {
        connection = getMysqlConnection();
        dao = new PostDAO(connection);
    }

    public static DBService Instance() {
        if (service == null) {
            service = new DBService();
        }
        return service;
    }

    public List<PostDataSet> getParsedGroups(int nicheId) {
        try {
            return dao.getPostsByNiche(nicheId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @SuppressWarnings("UnusedDeclaration")
    private static Connection getMysqlConnection() {
        try {
            DriverManager.registerDriver((Driver) Class.forName("com.mysql.jdbc.Driver").newInstance());

            StringBuilder url = new StringBuilder();

            url.
                    append("jdbc:mysql://").        //db type
                    append("localhost:").           //host name
                    append("3306/").                //port
                    append("doPost?").              //db name
                    append("user=root&").           //login
                    append("password=00755cnfc").   //password
                    append("&useUnicode=yes&characterEncoding=UTF-8");

            Connection connection = DriverManager.getConnection(url.toString());
            return connection;
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        DBService service = DBService.Instance();
        System.out.println(service.getParsedGroups(3).size());
    }
}