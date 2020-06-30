package com.gs.resource;

import com.gs.model.Objective;

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

    @GET
    public Object getObjectives() {
        /*
        @Context UriInfo uriInfo
        MultivaluedMap<String, String> params = uriInfo.getQueryParameters();
        if (params.size() > 0) {
            if (params.containsKey("parentId")) {
                return Objective.find("where parent_id = ?1", params.get("parentId"));
            }
        } else {}
        return null;*/
        return Objective.listAll();

    }

    @GET
    @Path("/{id}")
    public Objective getObjectiveById(@PathParam("id") Long id) {
        return Objective.findById(id);
    }

    /*@GET
    public Objective getObjectiveByParentId(@QueryParam("parent_id") Long id) {
        return (Objective) Objective.find("where parent_id = ?1", id);
    }

    @GET
    public Objective getObjectiveByDepartmentId(@QueryParam("department_id") Long id) {
        return (Objective) Objective.find("where department_id = ?1", id);
    }

    @GET
    public Objective getObjectiveByTypeId(@QueryParam("type_id") Long id) {
        return (Objective) Objective.find("where type_id = ?1", id);
    }

    @GET
    public Objective getObjectiveByOwnerId(@QueryParam("owner_id") Long id) {
        return (Objective) Objective.find("where owner_id = ?1", id);
    }*/

    @POST
    @Transactional
    public Objective createObjective(Objective objective) {
        Objective.persist(objective);
        return objective;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Objective updateObjective(@PathParam("id") Long id, Objective objective) {
        objective.id = id;
        Long typeId = objective.getType() != null ? objective.getType().id : null;
        Long departmentId = objective.getDepartment() != null ? objective.getDepartment().id : null;
        Long ownerId = objective.getOwner() != null ? objective.getOwner().id : null;
        Long parentId = objective.getParent() != null ? objective.getParent().id : null;

        Objective.update("title = ?1, description = ?2, type_id = ?3, parent_id = ?4, department_id = ?5, owner_id = ?6, start_date = ?7, end_date = ?8, status = ?9" +
                        " where id = ?10",
                objective.getTitle(), objective.getDescription(), typeId, parentId, departmentId, ownerId, objective.getStartDate(), objective.getEndDate(), objective.getStatus(), id);
        return objective;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteObjective(@PathParam("id") Long id) {
        return Objective.deleteById(id);
    }

}
