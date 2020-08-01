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
}
