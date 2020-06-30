package com.gs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

@Entity
public class Objective extends PanacheEntity {

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ObjectiveType type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Objective parent;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private Collection<Objective> children = new HashSet<>();

    @OneToMany(mappedBy = "objective")
    private Collection<KeyResult> keyResults = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    private Date startDate;
    private Date endDate;

    private String status;

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

    public ObjectiveType getType() {
        return type;
    }

    public void setType(ObjectiveType type) {
        this.type = type;
    }

    public Objective getParent() {
        return parent;
    }

    public void setParent(Objective parent) {
        this.parent = parent;
    }

    public Collection<Objective> getChildren() {
        return children;
    }

    public void setChildren(Collection<Objective> children) {
        this.children = children;
    }

    public Collection<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(Collection<KeyResult> keyResults) {
        this.keyResults = keyResults;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
