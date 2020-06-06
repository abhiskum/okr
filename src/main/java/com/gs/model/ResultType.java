package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;

@Entity
public class ResultType extends PanacheEntity {

    private String type;
    private String label;

    public String getType() {
        return type;
    }

    public ResultType setType(String type) {
        this.type = type;
        return this;
    }

    public String getLabel() {
        return label;
    }

    public ResultType setLabel(String label) {
        this.label = label;
        return this;
    }
}
