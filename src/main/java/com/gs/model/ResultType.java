package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;

@Entity
@Schema(name="ResultType",
        description="POJO that represents a result type.")
public class ResultType extends PanacheEntity {

    @Schema(required = true)
    private String type;
    @Schema(required = true)
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
