package com.gs.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by degandhi on 6/13/20.
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class GreetingResource {

    @GET
    public String hello() {
        return "hello";
    }
}
