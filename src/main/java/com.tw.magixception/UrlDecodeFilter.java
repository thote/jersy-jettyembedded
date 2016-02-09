package com.tw.magixception;


import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

import java.io.*;
import java.net.URLDecoder;

public class UrlDecodeFilter implements ContainerRequestFilter, ContainerResponseFilter {

    private long startTime;

    @Override
    public ContainerRequest filter(ContainerRequest request) {
        startTime = System.currentTimeMillis();
        System.out.println("inside request Filter : " + request.getPath());
        String encodedString = readUrlEncodedString(request);
        System.out.println("encoded stirng : " + encodedString);
        String decodedString  = new URLDecoder().decode(encodedString);
        System.out.println("decoded stirng : " + decodedString);
        request.setEntityInputStream(new ByteArrayInputStream(decodedString.getBytes()));
        return request;
    }

    private String readUrlEncodedString(ContainerRequest request) {
        InputStream stream = request.getEntityInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String s = reader.readLine();
            while(s != null) {
                stringBuilder.append(s);
                s = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }


    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        System.out.println("inside response filter : " + response.getResponse().getStatus());
        System.out.println("method: " + request.getMethod()
            + " path : " + request.getPath()
            + " time: " + (int) ((System.currentTimeMillis() - startTime))
            + " returnCode: " + response.getResponse().getStatus());
        return response;
    }
}
