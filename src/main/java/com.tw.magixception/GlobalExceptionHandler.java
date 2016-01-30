package com.tw.magixception;

import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.*;

public class GlobalExceptionHandler {

    public Response handleException(Exception e) {
        System.out.println(" handling generic exception : " + e.getMessage());
        return Response.status(INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
    }

    public Response handleException(IllegalArgumentException e) {
        System.out.println(" handling illegal argument exception : " + e.getMessage());
        return Response.status(BAD_REQUEST).entity(e.getMessage()).build();
    }

    public Response handleException(IndexOutOfBoundsException e) {
        System.out.println("array index bound exception " + e.getMessage());
        return Response.status(NOT_FOUND).entity(e.getMessage()).build();
    }

}

