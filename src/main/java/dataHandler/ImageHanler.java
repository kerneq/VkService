package dataHandler;

/**
 * Created by iters on 3/11/17.
 */
public class ImageHanler {
    public static String getFieldFromImg(String field, String text) {
    String find = field;
    int start = text.indexOf(find) + find.length();
    int end = text.indexOf(',', start + 1);
    return text.substring(start, end);
    }
}
