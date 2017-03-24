package db.dao;

import db.dataSets.PhotoDataSet;
import db.dataSets.PostDataSet;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iters on 3/24/17.
 */
public class PostDAO {
    private Connection connection;

    public PostDAO(Connection connection) {
        this.connection = connection;
    }

    public List<PostDataSet> getPostsByNiche(int nicheId) throws SQLException {
        //TODO: check if nicheId exist

        List<PostDataSet> posts = new ArrayList<>();
        Statement stm = connection.createStatement();

        String query = String.format("SELECT * FROM parse_from WHERE niche_id = %d;", nicheId);
        stm.execute(query);
        ResultSet result = stm.getResultSet();

        while(result.next()) {
            int id = result.getInt("id");
            query = String.format("SELECT * FROM photo WHERE post_id = %d;", id);
            stm.execute(query);

            ResultSet ph = stm.getResultSet();
            int size = ph.getFetchSize();
            PostDataSet p = new PostDataSet(size);

            while (ph.next()) {
                PhotoDataSet photo = new PhotoDataSet();
                photo.album_id = ph.getInt("album_id");
                photo.media_id = ph.getInt("media_id");
                photo.owner_id = ph.getInt("owner_id");
                photo.url = ph.getString("url");

                p.addPhoto(photo);
            }

            p.text = result.getString("text");
            p.likes = result.getInt("likes");
            p.comments = result.getInt("comments");
            p.reposts = result.getInt("reposts");
            posts.add(p);

            ph.close();
        }

        result.close();
        stm.close();
        return posts;
    }

}