package com.tw.magixception;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import java.io.IOException;

public class EncodeRequestInterceptor implements WriterInterceptor {


    @Override
    public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
        System.out.println("EncodeRequestInterceptor::aroundWriteTo");
        context.proceed();
    }
}
