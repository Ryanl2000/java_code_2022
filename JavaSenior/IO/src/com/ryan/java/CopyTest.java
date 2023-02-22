package com.ryan.java;

import org.junit.Test;

import java.io.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/25
 */
public class CopyTest {

    @Test
    public void test() {

        long start = System.currentTimeMillis();

//        copy("01-尚硅谷-Java语言高级-每天一考.avi", "dest1.avi", "file");
        copyBuffer("01-尚硅谷-Java语言高级-每天一考.avi", "dest2.avi");

        long end = System.currentTimeMillis();

        System.out.println(end - start);



    }

    public void copy(String srcPath, String destPath, String item) {

        if (item.equals("txt")) {
            FileReader fr = null;
            FileWriter fw = null;
            try {
                File f1 = new File(srcPath);
                File f2 = new File(destPath);

                fr = new FileReader(f1);
                fw = new FileWriter(f2);

                char[] cbuf = new char[5];
                int len;
                while ((len = fr.read(cbuf)) != -1) {
                    fw.write(new String(cbuf, 0, len));
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fr != null;
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    assert fw != null;
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (item.equals("file")) {
            FileInputStream fr = null;
            FileOutputStream fw = null;
            try {
                File f1 = new File(srcPath);
                File f2 = new File(destPath);

                fr = new FileInputStream(f1);
                fw = new FileOutputStream(f2);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = fr.read(buffer)) != -1) {
                    fw.write(buffer, 0, len);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    assert fr != null;
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    assert fw != null;
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new RuntimeException("输入的类型有误");
        }

    }

    public void copyBuffer(String src, String dest) {

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            File srcFile = new File(src);
            File destFile = new File(dest);

            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bos != null;
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bis != null;
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void test2() {

        BufferedReader bis = null;
        BufferedWriter bos = null;
        try {
            bis = new BufferedReader(new FileReader(new File("hello.txt")));
            bos = new BufferedWriter(new FileWriter(new File("hello3.txt")));

//            char[] cbuf = new char[1024];
//            int len;
//            while ((len = bis.read(cbuf)) != -1) {
//                bos.write(cbuf, 0, len);
//                bos.flush();
//            }

            String data;
            while ((data = bis.readLine()) != null) {
                bos.write(data);
                bos.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bis != null;
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bos != null;
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }
}
