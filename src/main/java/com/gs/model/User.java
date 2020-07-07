package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Schema(name="User",
        description="POJO that represents a user.")
public class User extends PanacheEntity {

    @Schema(required = true)
    private String firstName;
    @Schema(required = true)
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "User_Department",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "department_id") }
    )
    @Schema(required = true)
    private Collection<Department> departments = new HashSet<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Collection<Department> departments) {
        this.departments = departments;
    }
}
