package com.ryan.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 * @author RyanL
 * @description
 * @create 2022/7/29
 */
public class HTTPTest {

    public static void main(String[] args) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.baidu.com")).build();
            HttpResponse.BodyHandler<String> responseBodyHandler = HttpResponse.BodyHandlers.ofString();
            HttpResponse<String> response = client.send(request, responseBodyHandler);
            String body = response.body();
            System.out.println(body);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }




}
