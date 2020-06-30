package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class ObjectiveType extends PanacheEntity {

    private String type;
    private String label;

    @OneToMany(mappedBy = "type")
    private Collection<Objective> objectives = new HashSet<>();

    public String getType() {
        return type;
    }

    public ObjectiveType setType(String type) {
        this.type = type;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public ObjectiveType setLabel(String label) {
        this.label = label;
        return this;
    }

    public Collection<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(Collection<Objective> objectives) {
        this.objectives = objectives;
    }
}
