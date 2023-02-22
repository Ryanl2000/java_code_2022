package com.ryan.java;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author RyanL
 * @description
 * @create 2022/7/27
 */
public class TCPFileTest {

    @Test
    public void client() {

        Socket socket = null;
        OutputStream os = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            InetAddress inet = InetAddress.getByName("172.20.10.3");
            socket = new Socket(inet, 3108);

            os = socket.getOutputStream();
            bos = new BufferedOutputStream(os);

            fis = new FileInputStream("test.txt");
            bis = new BufferedInputStream(fis);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }

            socket.shutdownOutput();

            is = socket.getInputStream();
            baos = new ByteArrayOutputStream();
            byte[] buffer1 = new byte[1024];
            int len1;
            while ((len1 = is.read(buffer1)) != -1) {
                baos.write(buffer1, 0, len1);
                baos.flush();
            }
            System.out.println(baos.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert baos != null;
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void server() {

        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        OutputStream os = null;
        try {
            serverSocket = new ServerSocket(9090);
            socket = serverSocket.accept();

            is = socket.getInputStream();
            bis = new BufferedInputStream(is);

            fos = new FileOutputStream("tcptest.jpg");
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
                bos.flush();
            }
            System.out.println("传输完成，来自" + socket.getInetAddress().getHostName());

            os = socket.getOutputStream();
            os.write("已成功接收到来自你的数据".getBytes(StandardCharsets.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert os != null;
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

}
