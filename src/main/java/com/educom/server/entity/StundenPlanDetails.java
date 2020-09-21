package com.educom.server.entity;

import javax.persistence.*;

@Entity
@Table(name="stunden_plan_details")
public class StundenPlanDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    private StundenPlan stundenPlan;
    @OneToOne
    private Schuler schuler;
    private Boolean speateAnfang;
    private Double speateTeilnameMin;
    @Column(length = 255)
    private String unterrichtnote;
    private Boolean anwesend;
    private Boolean materialdabei;

}
