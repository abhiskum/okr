package com.gs.resource;

import com.gs.model.Objective;
import com.gs.model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/objectives")
@Consumes("application/json")
@Produces("application/json")
public class ObjectiveResource {

    @GET
    public Collection<Objective> getObjectives() {
        List<Objective> objectives = Objective.listAll();
        return objectives;
    }

    @POST
    @Transactional
    public Objective createObjective(Objective objective) {
        Objective.persist(objective);
        return objective;
    }

    @POST
    @Transactional
    public Objective updateObjective(Objective objective) {
        Objective.persist(objective);
        return objective;
    }

}
