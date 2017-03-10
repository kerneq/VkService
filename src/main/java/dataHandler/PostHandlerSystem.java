package dataHandler;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by iters on 3/8/17.
 */
public class PostHandlerSystem {
    private String workingPath = null;

    public PostHandlerSystem(String workingPath) {
        this.workingPath = workingPath;
    }

    public PostHandlerSystem() {}

    public Set<PostInfo> getImagesByPath() {
        if (workingPath == null) {
            return null;
        }

        Set<PostInfo> set = new HashSet<>();
        File workingDir = new File(workingPath);

        for (File file : workingDir.listFiles()) {
            if(file.isDirectory()) {
                recursiveByPass(file, set);
            }
        }
        return set;
    }

    private void recursiveByPass(File dir, Set<PostInfo> set) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory() && file.getName().matches("\\d+")) {
                set.add(getImgInformation(file.listFiles()));
            }
        }
    }

    private PostInfo getImgInformation(File[] files) {
        PostInfo post = new PostInfo();

        for (File file : files) {
            String name = file.getName();
            if (name.matches("\\d+\\.jpg")) {
                //TODO: max 5 photo!!!
                try {
                    post.imgUrls[post.len++] = file.getCanonicalPath();
                    // get url, ownerId and albumId
                    String path = file.getCanonicalPath();
                    path = path.substring(0, path.lastIndexOf(".")) + ".txt";

                    String[] lines = getTextFromFile(new File(path)).split("\\n");
                    String url = lines[0].substring(4, lines[0].length());
                    String id = lines[1].substring(3, lines[1].length());
                    String albumId = lines[2].substring(8, lines[2].length());
                    String ownerId = lines[3].substring(8, lines[3].length());

                    post.id = id;
                    post.url = url;
                    post.albumId = albumId;
                    post.ownerId = ownerId;
                    System.out.println("id: " + id);
                    System.out.println("album: " + albumId);
                    System.out.println("owner: " + ownerId);
                } catch (IOException e) {
                    //e.printStackTrace();
                    System.err.println("ошибка при добавлении в set изображения");
                }
            } else if (name.equalsIgnoreCase("statistic.txt")) {
                String[] lines = getTextFromFile(file).split("\\n");
                post.likes = Integer.parseInt(lines[0].substring(
                        lines[0].indexOf(":") + 1, lines[0].length()));
                post.reposts = Integer.parseInt(lines[1].substring(
                        lines[1].indexOf(":") + 1, lines[1].length()));
                post.comments = Integer.parseInt(lines[2].substring(
                        lines[2].indexOf(":") + 1, lines[2].length()));
            } else if (name.equalsIgnoreCase("title.txt")) {
                String txt = getTextFromFile(file);
                post.text = (txt.equals("")) ? null : txt;
            }
        }

        return post;
    }

    private String getTextFromFile(File file) {
        StringBuilder str = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                str.append(line + "\n");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str.toString();
    }

    public static void main(String[] args) {
        PostHandlerSystem test = new PostHandlerSystem("/home/iters/media/");
        System.out.println(test.getImagesByPath());
    }
}