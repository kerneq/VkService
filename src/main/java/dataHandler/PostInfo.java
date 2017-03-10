package dataHandler;

/**
 * Created by iters on 3/8/17.
 */
public class PostInfo {
    public String[] imgUrls;
    public String text;
    public int likes, comments, reposts;
    public int len;
    String url, albumId, ownerId, id;
    //TODO: add date, and ARRAY OF URLS!!!!

    public PostInfo() {
        imgUrls = new String[5];
        len = 0;
    }

    public String[] getImgUrls() {
        return imgUrls;
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

    public String getAlbumId() {
        return albumId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getUrl() {
        return url;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        StringBuilder answer = new StringBuilder("photo: {\n");

        for (String photo : imgUrls) {
            answer.append(photo + "\n");
        }
        answer.append("\n");
        answer.append("text: " + text + "\n");
        answer.append("likes: " + likes + "\n");
        answer.append("reposts: " + reposts + "\n");
        answer.append("comments: " + comments + "\n");
        return answer.toString();
    }
}