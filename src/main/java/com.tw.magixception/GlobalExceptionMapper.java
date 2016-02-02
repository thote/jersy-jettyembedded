package com.tw.magixception;


import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionMapper implements ExceptionMapper<Throwable> {

    private final ExceptionProcessor exceptionProcessor = new ExceptionProcessor();


    @Override
    public Response toResponse(Throwable e) {
        return e instanceof WebApplicationException
                ? ((WebApplicationException) e).getResponse()
                : exceptionProcessor.handleException(e);
    }
}
