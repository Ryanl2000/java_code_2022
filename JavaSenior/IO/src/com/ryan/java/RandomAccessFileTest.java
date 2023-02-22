package com.ryan.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/**
 * @author RyanL
 * @description
 * @create 2022/7/27
 */
public class RandomAccessFileTest {

    @Test
    public void test() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("hello1.txt","rw");

        raf1.seek(5);

        StringBuilder buffer = new StringBuilder((int) new File("hello1.txt").length());
        byte[] bytes = new byte[20];
        int len;
        while ((len = raf1.read(bytes)) != -1) {
            buffer.append(new String(bytes, 0, len));
        }

        raf1.seek(5);

        raf1.write("xyz".getBytes(StandardCharsets.UTF_8));

        raf1.write(buffer.toString().getBytes(StandardCharsets.UTF_8));

        raf1.close();
    }

}
