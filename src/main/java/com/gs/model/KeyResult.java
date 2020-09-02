package com.gs.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.gs.util.LocalDateDeserializer;
import com.gs.util.LocalDateSerializer;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@Schema(name="KeyResult",
        description="POJO that represents a key result.")
public class KeyResult extends PanacheEntity {

    @Schema(required = true)
    private String title;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "objective_id", nullable = false)
    @Schema(required = true)
    @JsonIgnoreProperties({"title","description","type","parent","children","department","owner","startDate","endDate","keyResults","status","notes","completion"})
    private Objective objective;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    @Schema(required = true)
    private User owner;

    @Schema(required = true)
    private Double currentState;

    private String notes;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(required = true)
    private LocalDate startDate;

    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    @Schema(required = true)
    private LocalDate endDate;

    private Double completion;

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

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Double getCurrentState() {
        return currentState;
    }

    public void setCurrentState(Double currentState) {
        this.currentState = currentState;
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

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Double getCompletion() {
        return completion;
    }

    public void setCompletion(Double completion) {
        this.completion = completion;
    }
}
