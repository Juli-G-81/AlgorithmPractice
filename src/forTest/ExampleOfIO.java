package forTest;


import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * @author ：Juli
 * @date ： 2023/5/4 11:14 AM
 * @description：
 * @modifiedBy ：
 * @version:
 */


public class ExampleOfIO {

    public static void main(String[] args) {
        String url = "https://bj.58.com/"; // 定义要请求的URL地址
        HttpURLConnection connection = null; // 定义HttpURLConnection对象，用于发送请求和读取响应
        StringBuilder contentBuilder = new StringBuilder(); // 定义StringBuilder对象，用于存储响应内容

        try {
            URL targetUrl = new URL(url); // 创建URL对象
            connection = (HttpURLConnection) targetUrl.openConnection(); // 打开连接
            connection.setRequestMethod("GET"); // 设置请求方法
            connection.setConnectTimeout(5000); // 设置连接超时时间
            connection.setReadTimeout(5000); // 设置读取超时时间

            if (connection.getResponseCode() == 200) { // 如果响应码为200，表示请求成功
                InputStream inputStream = connection.getInputStream(); // 获取响应内容的输入流
                Reader reader = new InputStreamReader(inputStream, "utf-8"); // 将输入流转换成字符流，并指定编码格式

                int data = reader.read(); // 读取字符流中的数据
                while (data != -1) { // 当读取的数据不为-1时，说明还没有读到末尾
                    contentBuilder.append((char) data); // 将读取的数据添加到StringBuilder对象中
                    data = reader.read(); // 继续读取下一个字符
                }

                String content = contentBuilder.toString(); // 将StringBuilder对象转换成字符串
                String filteredContent = content.replaceAll("<[^>]+>", ""); // 使用正则表达式过滤html标签

                FileWriter writer = new FileWriter("result.txt");
                writer.write(filteredContent);
                writer.close();
            } else {
                System.out.println("请求失败，响应码：" + connection.getResponseCode());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect(); // 断开连接，释放资源
            }
        }
    }

}
