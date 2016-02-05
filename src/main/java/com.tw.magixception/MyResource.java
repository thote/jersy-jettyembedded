package com.tw.magixception;

import com.sun.jersey.api.core.InjectParam;

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
    @Path("/qp")
    @Produces("application/json")
    public Person gerPerson(@InjectParam PersonQuery query) {
        System.out.println("getPerson : " + query);
        Person p = new Person();
        p.setFirstName(query.getFirstName());
        p.setLastName(query.getLastName());
        System.out.println(" returning person : returning : " + p );
        return p;
    }

    @GET
    @Path("/qp1")
    @Produces("application/json")
    public Person gerPerson1(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName) {
        System.out.println("getPerson1 : " + firstName + lastName);
        Person p = new Person();
        p.setFirstName("MySeflf");
        p.setLastName("SomeoneElse");
        System.out.println(" returning person : returning : " + p );
        return p;
    }

    @POST
    @Path("/body")
    @Produces("application/json")
    @Consumes("application/json")
    public Person postPerson(Person person) {
        System.out.println(" person : " + person);
       return person;
    }

    @POST
    @Path("/encodedbody")
    @Produces("application/json")
    @Consumes("application/json")
    public Person encodedPerson(Person person) {
        System.out.println(" person : " + person);
        return person;
    }


//    @GET
//    @Path("/pp/{path}/pp")
//    @Produces("application/json")
//    @Consumes("application/json")
//    public Person pathParam(@PathParam("path") Person person) {
//        System.out.println(" getPerson : returning : " + person );
//        return new Person();
//    }


    @GET
    @Path("/async")
    public void async(@Suspended AsyncResponse response) {
        throw new IndexOutOfBoundsException("Don't ask me what I don't have");
    }

}
