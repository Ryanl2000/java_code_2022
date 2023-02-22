package com.ryan.java;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author RyanL
 * @description
 * @create 2022/7/23
 */
public class MapTest {

    @Test
    public void test() {
        Map map = new HashMap();
//        map = new Hashtable();

        map.put(11,123);
        map.put("AD",154);
        map.put("AC","AV");

        System.out.println(map);

        Set entry = map.entrySet();
        Iterator iterator = entry.iterator();

        while (iterator.hasNext()) {
            Object obj = iterator.next();
            Map.Entry entry1 = (Map.Entry) obj;
            System.out.println(entry1.getKey() + "--->" + entry1.getValue());
        }

    }

    @Test
    public void testProperties() throws IOException {
        Properties properties = new Properties();

        FileInputStream fis = new FileInputStream("D:\\Java\\JavaCode\\JavaSenior\\jdbc.properties");

        properties.load(fis);

        String name = properties.getProperty("name");

        System.out.println(name);
    }
}
