package com.gs.resource;

import com.gs.model.Department;

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

@Path("/departments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartmentResource {

    @GET
    public Collection<Department> getDepartments() {
        return Department.listAll();
    }

    @GET
    @Path("/{id}")
    public Department getDepartmentById(@PathParam("id") Long id) {
        return Department.findById(id);
    }

    @POST
    @Transactional
    public Department createDepartment(Department department) {
        Department.persist(department);
        return department;
    }

    @PUT
    @Transactional
    @Path("/{id}")
    public Department updateDepartment(@PathParam("id") Long id, Department department) {
        department.id = id;
        Department.update("name = ?1, parent = ?2 where id = ?3",
                department.getName(), department.getParent(), id);
        return department;
    }

    @DELETE
    @Transactional
    @Path("/{id}")
    public Boolean deleteDepartment(@PathParam("id") Long id){
        return Department.deleteById(id);
    }

}
