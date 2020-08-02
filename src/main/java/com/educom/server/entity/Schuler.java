package com.educom.server.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="schuler")
@Getter
@Setter
public class Schuler extends Person{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private long id;
    private String vater;
    private String mutter;

    @ManyToOne
    @JoinColumn(name = "schule_id")
    private  Schule schule;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "schuler_kurs",
            joinColumns = { @JoinColumn(name = "schuler_id") },
            inverseJoinColumns = { @JoinColumn(name = "kurs_id") }
    )
    private Set<Kurs> kurses = new HashSet<>();



    public Schuler() {
    }


}
