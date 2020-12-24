package org.acme.resteasyjackson;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
public class Quark extends PanacheEntity {

    public String name;
    public String description;

    public Quark() {
    }

    public Quark(String name, String description) {
        this.name = name;
        this.description = description;
    }
}