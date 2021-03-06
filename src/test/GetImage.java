package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * @说明 从网络获取图片到本地
 * @author
 * @version 1.0
 * @since
 */

public class GetImage {
    /**
     * 下载一张网络图片到本地磁盘
     * 
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {

        String urlStr = "https://img.pic123456.com/girl/第51期合集/1.jpg";
        String docname = urlStr.substring(26);
        System.out.println(docname);
        urlStr = urlStr.substring(0, 26) + URLEncoder.encode(docname, "UTF-8");
        System.out.println(urlStr);
        GetImage getImage = new GetImage();
        getImage.downloadOneImage(urlStr);
        // getImage.downloadOneImage("https://img.pic123456.com/" +
        // URLEncoder.encode("girl/第51期合集/1.jpg", "UTF-8"));
    }

    private static int nameNumber = 0;

    public void downloadOneImage(String urlString) throws Exception {

        // new一个URL对象
        URL url = new URL(urlString);

        // 打开链接
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        // parser = new Parser(conn);
        // conn.setEncoding("gb2312");

        // 设置请求方式为"GET"
        conn.setRequestMethod("GET");
        // 超时响应时间为5秒
        conn.setConnectTimeout(5 * 1000);
        // 通过输入流获取图片数据
        InputStream inStream = conn.getInputStream();
        // 得到图片的二进制数据，以二进制封装得到数据，具有通用性
        byte[] data = readInputStream(inStream);
        if (data != null) {
            // new一个文件对象用来保存图片，默认保存当前工程根目录
            String fileName = "D:\\ss.jpg";
            File imageFile = new File(fileName);
            // 创建输出流
            FileOutputStream outStream = new FileOutputStream(imageFile);
            // 写入数据
            outStream.write(data);
            // 关闭输出流
            outStream.close();
            System.out.println("下载完成：" + String.valueOf(nameNumber));
        }

    }

    public static byte[] readInputStream(InputStream inStream) throws Exception {
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        // 创建一个Buffer字符串
        byte[] buffer = new byte[1024];
        // 每次读取的字符串长度，如果为-1，代表全部读取完毕
        int len = 0;
        // 使用一个输入流从buffer里把数据读取出来
        while ((len = inStream.read(buffer)) != -1) {
            // 用输出流往buffer里写入数据，中间参数代表从哪个位置开始读，len代表读取的长度
            outStream.write(buffer, 0, len);
        }
        // 关闭输入流
        inStream.close();
        // 把outStream里的数据写入内存
        return outStream.toByteArray();
    }
}
