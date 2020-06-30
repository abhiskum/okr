package com.gs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class Department extends PanacheEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Department parent;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private Collection<Department> children = new HashSet<>();

    @ManyToMany(mappedBy = "departments")
    @JsonIgnore
    private Collection<User> users = new HashSet<>();

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Collection<Objective> objectives = new HashSet<>();

    @OneToMany(mappedBy = "department")
    @JsonIgnore
    private Collection<KeyResult> keyResults = new HashSet<>();

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

    public Collection<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(Collection<Objective> objectives) {
        this.objectives = objectives;
    }

    public Collection<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(Collection<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }
}
