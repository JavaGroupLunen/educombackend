package com.educom.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "person_type")
public class PersonType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="type_name")
    private Ptype typeName;

    public PersonType() {
    }

    public PersonType(Ptype typeName) {
        this.typeName = typeName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Ptype getTypeName() {
        return typeName;
    }

    public void setTypeName(Ptype typeName) {
        this.typeName = typeName;
    }
}
