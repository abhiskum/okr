package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class KeyResult extends PanacheEntity {
    
    private String title;
    private String description;
    @ManyToOne(optional = false) private ResultType type;
    @ManyToOne(optional = false) private Objective parent;
    @ManyToOne(optional = false) private User owner;
    private Integer start;
    private Integer target;

    public String getTitle() {
        return title;
    }

    public KeyResult setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public KeyResult setDescription(String description) {
        this.description = description;
        return this;
    }

    public ResultType getType() {
        return type;
    }

    public KeyResult setType(ResultType type) {
        this.type = type;
        return this;
    }

    public Objective getParent() {
        return parent;
    }

    public KeyResult setParent(Objective parent) {
        this.parent = parent;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public KeyResult setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Integer getStart() {
        return start;
    }

    public KeyResult setStart(Integer start) {
        this.start = start;
        return this;
    }

    public Integer getTarget() {
        return target;
    }

    public KeyResult setTarget(Integer target) {
        this.target = target;
        return this;
    }
}
