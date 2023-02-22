package com.ryan.java;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author RyanL
 * @description
 * @create 2022/7/27
 */
public class InetAddressTest {

    public static void main(String[] args) throws UnknownHostException {

        InetAddress name = InetAddress.getByName("www.baidu.com");

        System.out.println(InetAddress.getLocalHost());

        System.out.println(name);


    }

}
