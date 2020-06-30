package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
public class ResultType extends PanacheEntity {

    private String type;
    private String label;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private Collection<KeyResult> keyResults;

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

    public Collection<KeyResult> getKeyResults() {
        return keyResults;
    }

    public void setKeyResults(Collection<KeyResult> keyResults) {
        this.keyResults = keyResults;
    }
}
