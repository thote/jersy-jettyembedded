package com.tw.magixception;


import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

public class ExceptionFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public ContainerRequest filter(ContainerRequest request) {
        System.out.println("inside request : " + request.getPath());

        return request;
    }

    @Override
    public ContainerResponse filter(ContainerRequest request, ContainerResponse response) {
        System.out.println("inside response filter : " + response.getResponse().getStatus());
        return response;
    }
}
