package com.gs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class User extends PanacheEntity {

    private String firstName;
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "User_Department",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "department_id") }
    )
    private Collection<Department> departments = new HashSet<>();

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Collection<Objective> objectives = new HashSet<>();

    @OneToMany(mappedBy = "owner")
    @JsonIgnore
    private Collection<KeyResult> keyResults = new HashSet<>();

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
