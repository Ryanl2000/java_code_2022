package com.ryan.exer;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author RyanL
 * @description
 * @create 2022/7/26
 */
public class NumCharTest {

    @Test
    public void test() {

        HashMap<Character, Integer> map = new HashMap<>();
        FileReader fr = null;
        FileWriter fw = null;

        try {
            fr = new FileReader("hello.txt");
            fw = new FileWriter("HashMap.txt");
            char[] c = new char[1024];
            int len;
            while ((len = fr.read(c)) != -1) {
                for (int i = 0; i < len; i++) {
                    if (map.get(c[i]) == null) {
                        map.put(c[i], 1);
                    } else {
                        int num = map.get(c[i]);
                        map.put(c[i], num + 1);
                    }
                }
            }
            Set<Map.Entry<Character, Integer>> set = map.entrySet();
            for (Map.Entry<Character, Integer> m : set) {
                if (m.getKey() == '\n')
                    fw.write("换行" + "--->" + m.getValue() + '\n');
                else
                    fw.write(m.getKey() + "--->" + m.getValue() + '\n');
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

    }

    @Test
    public void test2() {

        HashMap<Character, Integer> map = new HashMap<>();

        map.put('c', 1);

        int t = map.get('A');
        System.out.println(t);


    }
}
