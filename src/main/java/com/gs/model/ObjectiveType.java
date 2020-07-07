package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;

@Entity
@Schema(name="ObjectiveType",
        description="POJO that represents a objective type.")
public class ObjectiveType extends PanacheEntity {

    @Schema(required = true)
    private String type;
    @Schema(required = true)
    private String label;

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
}
