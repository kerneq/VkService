package db.dataSets;

/**
 * Created by iters on 3/8/17.
 */
public class PostDataSet {
    public PhotoDataSet[] photos;
    public String text;
    public int likes, comments, reposts;
    private int len;

    public PostDataSet(int photoCount) {
        photos = new PhotoDataSet[photoCount];
        len = 0;
    }

    public void addPhoto(PhotoDataSet photo) {
        photos[len++] = photo;
    }

    public PhotoDataSet[] getPhotos() {
        return photos;
    }

    public String getText() {
        return text;
    }

    public int getLikes() {
        return likes;
    }

    public int getComments() {
        return comments;
    }

    public int getReposts() {
        return reposts;
    }

    public int getLen() {
        return len;
    }
}