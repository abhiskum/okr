package com.gs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Schema(name = "Department",
        description = "POJO that represents a department.")
public class Department extends PanacheEntity {

    @Schema(required = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonIgnoreProperties({"name","parent","children", "users"})
    private Department parent;

    @OneToMany(mappedBy = "parent")
    @JsonIgnoreProperties({"name","parent","children", "users"})
    private Collection<Department> children = new HashSet<>();

    @ManyToMany(mappedBy = "departments")
    @JsonIgnoreProperties({"departments"})
    private Collection<User> users = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getParent() {
        return parent;
    }

    public void setParent(Department parent) {
        this.parent = parent;
    }

    public Collection<Department> getChildren() {
        return children;
    }

    public void setChildren(Collection<Department> children) {
        this.children = children;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
