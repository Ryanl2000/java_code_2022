package com.ryan.java;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author RyanL
 * @description
 * @create 2022/7/27
 */
public class URLTest {

    @Test
    public void test() {

        HttpURLConnection connection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F1113%2F052420110515%2F200524110515-2-1200.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1661507564&t=53408a88486b153e26db410d431a2a09");

            connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            is = connection.getInputStream();
            fos = new FileOutputStream("url.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

            System.out.println("下载完成");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            connection.disconnect();
        }
    }
}
