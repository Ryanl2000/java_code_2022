package com.ryan.java;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author RyanL
 * @description
 * @create 2022/7/27
 */
public class UDPTest {

    @Test
    public void sender() throws IOException {

        DatagramSocket socket = new DatagramSocket();

        String str = "我是UDP方式发送的数据";
        byte[] data = str.getBytes();
        DatagramPacket packet = new DatagramPacket(data, 0, data.length, InetAddress.getByName("127.0.0.1"), 9090);

        socket.send(packet);

        socket.close();

    }

    @Test
    public void receiver() throws IOException {

        DatagramSocket socket = new DatagramSocket(9090);

        byte[] bytes = new byte[100];
        DatagramPacket packet = new DatagramPacket(bytes, 0, bytes.length);

        socket.receive(packet);

        System.out.println(new String(packet.getData(), 0, packet.getLength()));

        socket.close();
    }
}
