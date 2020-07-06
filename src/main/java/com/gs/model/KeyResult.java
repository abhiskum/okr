package com.gs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class KeyResult extends PanacheEntity {

    private String title;
    private String description;
    @ManyToOne(optional = false,cascade = CascadeType.ALL)
    @JoinColumn(name = "type_id")
    @JsonBackReference
    private ResultType type;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "objective_id")
    @JsonBackReference
    private Objective objective;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    /*private Integer status;
    private Integer target;*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public ResultType getType() {
        return type;
    }

    public void setType(ResultType type) {
        this.type = type;
    }
}
