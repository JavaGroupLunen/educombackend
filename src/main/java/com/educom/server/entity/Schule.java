package com.educom.server.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="schule")
public class Schule implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "schule_name", nullable = false)
    private String name;
    @OneToMany(mappedBy = "schule")
    private List<Schuler> schulers;
}
