package com.gs.resource;

import com.gs.model.ObjectiveType;

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

/**
 * Created by degandhi on 6/30/20.
 */
@Path("/objectiveTypes")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ObjectiveTypeResource {

    @GET
    public Collection<ObjectiveType> getObjectiveTypes() {
        return ObjectiveType.listAll();
    }

    @GET
    @Path("/{id}")
    public ObjectiveType getObjectiveTypeById (@PathParam("id") Long id) {
        ObjectiveType objectiveType = ObjectiveType.findById(id);
        return objectiveType;
    }

    @POST
    @Transactional
    public ObjectiveType createObjectiveType(ObjectiveType objectiveType) {
        ObjectiveType.persist(objectiveType);
        return objectiveType;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public ObjectiveType updateObjectiveType(@PathParam("id") Long id, ObjectiveType objectiveType) {
        objectiveType.id = id;
        ObjectiveType.update("type = ?1, label = ?2 where id = ?3",
                objectiveType.getType(), objectiveType.getLabel(), id);
        return objectiveType;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteObjectiveType(@PathParam("id") Long id){
        return ObjectiveType.deleteById(id);
    }
}
