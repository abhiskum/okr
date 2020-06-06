package com.gs.resource;

import com.gs.model.Objective;
import com.gs.model.User;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/users")
@Consumes("application/json")
@Produces("application/json")
public class UserResource {

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

    @GET
    @Path("/{userId}/objectives")
    public Collection<Objective> getObjectives(@PathParam("userId") String userId) {
        List<Objective> objectives = Objective.list("owner", User.findById(userId));
        return objectives;
    }


}
