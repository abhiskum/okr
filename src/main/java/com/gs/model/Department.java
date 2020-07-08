package com.gs.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;

@Entity
@Schema(name="Department",
        description="POJO that represents a department.")
public class Department extends PanacheEntity {

    @Schema(required = true)
    private String name;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private Department parent;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private Collection<Department> children = new HashSet<>();

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

}
