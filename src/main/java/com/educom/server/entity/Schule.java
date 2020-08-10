package com.educom.server.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="schule")
public class Schule  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "schule_name", nullable = false)
    private String name;
    @Transient
    @OneToMany(mappedBy = "schule", fetch = FetchType.EAGER)
    private List<Schuler> Schulerlist = new LinkedList<>();


}
