package com.ryan.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author RyanL
 * @description
 * @create 2022/7/26
 */
public class EncrypTest {

    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("test.jpg");
            fos = new FileOutputStream("secret.jpg");

            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1) {
                for (int i = 0; i < len; i++) {
                    buf[i] ^= 5;
                }
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test2() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("secret.jpg");
            fos = new FileOutputStream("show.jpg");

            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) != -1) {
                for (int i = 0; i < len; i++) {
                    buf[i] ^= 5;
                }
                fos.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fis != null;
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert fos != null;
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
