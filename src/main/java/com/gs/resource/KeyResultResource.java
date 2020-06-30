package com.gs.resource;

import com.gs.model.KeyResult;

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
@Path("/keyResults")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KeyResultResource {

    @GET
    public Collection<KeyResult> getKeyResults() {
        return KeyResult.listAll();
    }

    @GET
    @Path("/{id}")
    public KeyResult getKeyResultById(@PathParam("id") Long id) {
        return KeyResult.findById(id);
    }

    @POST
    @Transactional
    public KeyResult createKeyResult(KeyResult keyResult) {
        KeyResult.persist(keyResult);
        return keyResult;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public KeyResult updateKeyResult(@PathParam("id") Long id, KeyResult keyResult) {
        keyResult.id = id;
        Long objectiveId = keyResult.getObjective() != null ? keyResult.getObjective().id : null;
        Long departmentId = keyResult.getDepartment() != null ? keyResult.getDepartment().id : null;
        Long ownerId = keyResult.getOwner() != null ? keyResult.getOwner().id : null;
        KeyResult.update("title = ?1, description = ?2, objective_id = ?3, owner_id = ?4,  department_id = ?5 where id = ?6",
                keyResult.getTitle(), keyResult.getDescription(), objectiveId, departmentId, ownerId, id);
        return keyResult;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteKeyResult(@PathParam("id") Long id) {
        return KeyResult.deleteById(id);
    }
}
