package com.gs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gs.util.LocalDateDeserializer;
import com.gs.util.LocalDateSerializer;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Schema(name="Objectives",
        description="POJO that represents an objective.")
public class Objective extends PanacheEntity {

    @Schema(required = true)
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private ObjectiveType type;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Objective parent;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private Collection<Objective> children = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "department_id")
    @Schema(required = true)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Schema(required = true)
    private User owner;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(required = true)
    private LocalDate startDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(required = true)
    private LocalDate endDate;

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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
