package com.educom.server.entity;

import javax.persistence.*;

@Entity
@Table(name="bemerkung")
public class Bemerkung {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;

    public Bemerkung() {

    }
}
