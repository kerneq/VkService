package db.dataSets;

/**
 * Created by iters on 3/24/17.
 */
public class PhotoDataSet {
    public int media_id, album_id, owner_id;
    public String url;

    public PhotoDataSet() {}

    public int getMedia_id() {
        return media_id;
    }

    public int getAlbum_id() {
        return album_id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public String getUrl() {
        return url;
    }
}