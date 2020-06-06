package com.gs.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class OrgHierarchy extends PanacheEntity {

    private String name;
    @ManyToOne
    private OrgHierarchy parent;
    @OneToMany
    private Collection<OrgHierarchy> children;




}
