package com.codegym.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "provinces")
public class Provinces {
    @Id
    private Long id;
    private String conscious;

    public Provinces() {
    }

    public Provinces(Long id, String conscious) {
        this.id = id;
        this.conscious = conscious;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConscious() {
        return conscious;
    }

    public void setConscious(String conscious) {
        this.conscious = conscious;
    }
}
