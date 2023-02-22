package com.ryan.java;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author RyanL
 * @description
 * @create 2022/7/24
 */
public class FileTest {

    public static void main(String[] args) {

        FileReader fr = null;
        try {
            File file = new File("hello.txt");
            fr = new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while ((len = fr.read(cbuf)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuf[i]);

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
