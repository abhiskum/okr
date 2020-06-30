package com.gs.resource;

import com.gs.model.Objective;
import com.gs.model.User;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @GET
    public Collection<User> getUsers() {
        return User.listAll();
    }

    @GET
    @Path("/{userId}")
    public User getUserById(@PathParam("userId") Long userId) {
        User user = User.findById(userId);
        return user;
    }

    @POST
    @Transactional
    public User createUser(User user) {
        User.persist(user);
        return user;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public User updateUser(@PathParam("id") Long id, User user) {
        user.id = id;
        User.update("firstName = ?1, lastName = ?2 where id = ?3",
                user.getFirstName(), user.getLastName(), id);
        return user;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteUser(@PathParam("id") Long id){
        return User.deleteById(id);
    }

    @GET
    @Path("/{userId}/objectives")
    public Collection<Objective> getObjectives(@PathParam("userId") String userId) {
        List<Objective> objectives = Objective.list("owner", User.findById(userId));
        return objectives;
    }

}
