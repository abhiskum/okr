package com.gs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Schema(name="KeyResult",
        description="POJO that represents a key result.")
public class KeyResult extends PanacheEntity {

    @Schema(required = true)
    private String title;

    private String description;

    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "objective_id",nullable = false)
    @Schema(required = true)
    @JsonIgnoreProperties({"title","description","type","parent","children","department","owner","startDate","endDate","keyResults","status","notes"})
    private Objective objective;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @Schema(required = true)
    @JsonIgnoreProperties({"parent","children","users"})
    private Department department;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Schema(required = true)
    private User owner;

    @Schema(required = true)
    private Long currentState;

    @Schema(required = true)
    private Long targetState;

    private String notes;

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

    public Long getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Long currentState) {
        this.currentState = currentState;
    }

    public Long getTargetState() {
        return targetState;
    }

    public void setTargetState(Long targetState) {
        this.targetState = targetState;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
