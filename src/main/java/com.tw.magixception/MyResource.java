package com.tw.magixception;

import javax.ws.rs.*;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.Response;

@Path("myresource")
public class MyResource {


    @GET
    @Path("/getit")
    @Produces("text/plain")
    public String getIt() {
        System.out.println("inside getit"  + Thread.currentThread().getName());
        return "Got it! ";
    }

    @GET
    @Path("/killit")
    @Produces("text/plain")
    public String killIt() {
        System.out.println("inside killit :"  + Thread.currentThread().getName());
        return "killing it it!";
    }

    @GET
    @Path("/null")
    @Produces("text/plain")
    public String nullit() {
        throw new NullPointerException("Failing early is good");
    }


    @GET
    @Path("/illegalarg")
    @Produces("text/plain")
    public String illegalArg() {
        throw new IllegalArgumentException("Give me what I need");
    }


    @GET
    @Path("/notfound")
    @Produces("text/plain")
    public String notFound() {
        throw new IndexOutOfBoundsException("Don't ask me what I don't have");
    }


    @GET
    @Path("/sync")
    public Response sync() {
        throw new IndexOutOfBoundsException("Don't ask me what I don't have");
    }

    @GET
    @Path("/async")
    public void async(@Suspended AsyncResponse response) {
        throw new IndexOutOfBoundsException("Don't ask me what I don't have");
    }

    @GET
    @Path("/qp")
    @Produces("application/json")
    public Person queryParam() {
        System.out.println(" getperson : returning : " + new Person() );
        return new Person();
    }
    
    @POST
    @Path("/body")
    @Produces("application/json")
    @Consumes("application/json")
    public Person body(Person person) {
        System.out.println(" person : " + person);
       return person;
    }
}
