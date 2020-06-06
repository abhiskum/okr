package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Objective extends PanacheEntity {

    private String title;
    private String description;
    @ManyToOne private ObjectiveType type;
    @ManyToOne private Objective parent;
    @OneToMany private Collection<KeyResult> keyResults;
    @OneToMany private Collection<Objective> children;
    @ManyToOne private OrgHierarchy hierarchy;
    @ManyToOne private User owner;
    private Date startDate;
    private Date endDate;

    public String getTitle() {
        return title;
    }

    public Objective setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Objective setDescription(String description) {
        this.description = description;
        return this;
    }

    public ObjectiveType getType() {
        return type;
    }

    public Objective setType(ObjectiveType type) {
        this.type = type;
        return this;
    }

    public Objective getParent() {
        return parent;
    }

    public Objective setParent(Objective parent) {
        this.parent = parent;
        return this;
    }

    public Collection<KeyResult> getKeyResults() {
        return keyResults;
    }

    public Objective setKeyResults(Collection<KeyResult> keyResults) {
        this.keyResults = keyResults;
        return this;
    }

    public Collection<Objective> getChildren() {
        return children;
    }

    public Objective setChildren(Collection<Objective> children) {
        this.children = children;
        return this;
    }

    public User getOwner() {
        return owner;
    }

    public Objective setOwner(User owner) {
        this.owner = owner;
        return this;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Objective setStartDate(Date startDate) {
        this.startDate = startDate;
        return this;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Objective setEndDate(Date endDate) {
        this.endDate = endDate;
        return this;
    }
}
