package com.educom.server.entity;

import org.joda.time.DateTime;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="stunden_plan")
public class StundenPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate datum;
    private DateTime beginzeit;
    private DateTime endzeit;
    private String raum;
    @OneToOne
    private Kurs kurs;
    @OneToOne
    private Lehre lehre;
    private Boolean vertreitung;
    @OneToMany
    private List<StundenPlanDetails> detail;
}
