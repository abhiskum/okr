package com.gs.resource;

import com.gs.model.KeyResult;
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
import java.util.Collection;

/**
 * Created by degandhi on 6/30/20.
 */
@Path("/keyresults")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KeyResultResource {

    @Inject
    private EntityManager entityManager;

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
        if(keyResult.getObjective() != null && keyResult.getObjective().id != null){
            Objective objective = entityManager.getReference(Objective.class, keyResult.getObjective().id);
            keyResult.setObjective(objective);
        }
        KeyResult.persist(keyResult);
        return keyResult;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public KeyResult updateKeyResult(@PathParam("id") Long id, KeyResult keyResult) {
        keyResult.id = id;
        return entityManager.merge(keyResult);
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteKeyResult(@PathParam("id") Long id) {
        return KeyResult.deleteById(id);
    }
}
