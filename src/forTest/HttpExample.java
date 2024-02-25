package forTest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URLConnection;
import java.net.URL;


/**
 * @author ：Juli
 * @date ： 2023/5/4 11:06 AM
 * @description：
 * @modifiedBy ：
 * @version:
 */
public class HttpExample {
    public static void main(String[] args) throws Exception {

        String url = "https://bj.58.com/";
        String filename = "page.html";
        String content = httpGet(url);
        String filteredContent = filterHtmlTags(content);
        saveToFile(filteredContent, filename);
    }

    private static String httpGet(String url) throws Exception {
        URLConnection connection = new URL(url).openConnection();
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        return sb.toString();
    }

    private static String filterHtmlTags(String content) {
        return content.replaceAll("<.*?>", "");
    }

    private static void saveToFile(String content, String filename) throws Exception {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write(content);
        writer.close();
    }
}
