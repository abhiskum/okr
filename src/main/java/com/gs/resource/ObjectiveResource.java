package com.gs.resource;

import com.gs.model.Objective;

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

@Path("/objectives")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ObjectiveResource {

    @Inject
    private EntityManager entityManager;

    @GET
    public Object getObjectives() {
        return Objective.listAll();

    }

    @GET
    @Path("/{id}")
    public Objective getObjectiveById(@PathParam("id") Long id) {
        return Objective.findById(id);
    }

    @POST
    @Transactional
    public Objective createObjective(Objective objective) {
        Objective.persist(objective);
        return objective;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Objective updateObjective(@PathParam("id") Long id, Objective obj) {
        Objective objective = entityManager.find(Objective.class, id);
        objective.setTitle(obj.getTitle());
        objective.setDescription(obj.getDescription());
        objective.setParent(obj.getParent());
        objective.setDepartment(obj.getDepartment());
        objective.setType(obj.getType());
        objective.setOwner(obj.getOwner());
        objective.setType(obj.getType());
        objective.setStartDate(obj.getStartDate());
        objective.setEndDate(obj.getEndDate());
        objective.setStatus(obj.getStatus());
        objective.setKeyResults(obj.getKeyResults());
        objective.setNotes(obj.getNotes());
        objective.setCompletion(obj.getCompletion());
        return entityManager.merge(objective);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteObjective(@PathParam("id") Long id) {
        return Objective.deleteById(id);
    }

}
