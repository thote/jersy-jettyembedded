package com.tw.magixception;

import lombok.Data;

import javax.ws.rs.QueryParam;

@Data
public class PersonQuery {
    @QueryParam("firstName")
    private String firstName;

    @QueryParam("lastName")
    private String lastName;

}
