package com.gs.resource;

import com.gs.model.Department;
import com.gs.model.Objective;
import com.gs.model.User;

import javax.inject.Inject;
import javax.persistence.EntityManager;
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
import java.util.HashSet;
import java.util.List;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private EntityManager entityManager;

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
        if (!user.getDepartments().isEmpty()) {
            Collection<Department> userDepartments = new HashSet<>();
            for (Department dept : user.getDepartments()) {
                Department department = entityManager.getReference(Department.class, dept.id);
                userDepartments.add(department);
            }
            user.setDepartments(userDepartments);
        }
        User.persist(user);
        return user;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public User updateUser(@PathParam("id") Long id, User user) {
        user.id = id;
        return entityManager.merge(user);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteUser(@PathParam("id") Long id) {
        return User.deleteById(id);
    }

    @GET
    @Path("/{userId}/objectives")
    public Collection<Objective> getObjectives(@PathParam("userId") String userId) {
        List<Objective> objectives = Objective.list("owner", User.findById(userId));
        return objectives;
    }

}
