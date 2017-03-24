package db.dataSets;

/**
 * Created by iters on 3/24/17.
 */
public class PhotoDataSet {
    public String media_id, album_id, owner_id;
    public String url;

    public PhotoDataSet() {}

    public String getMedia_id() {
        return media_id;
    }

    public String getAlbum_id() {
        return album_id;
    }

    public String getOwner_id() {
        return owner_id;
    }

    public String getUrl() {
        return url;
    }
}