package com.gs.resource;

import com.gs.model.User;

import java.util.Collection;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/users")
@Consumes("application/json")
@Produces("application/json")
public class OrgHierarchyResource {

    @GET
    public Collection<User> getUsers() {
        return User.listAll();
    }

    @POST
    @Transactional
    public User createUser(User user) {
        User.persist(user);
        return user;
    }

}
