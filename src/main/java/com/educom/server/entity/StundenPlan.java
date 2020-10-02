package com.educom.server.entity;


import org.joda.time.DateTime;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="stunden_plan")
public class StundenPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private LocalDate datum;
    private Time beginn;
    private Time ende;
    private String raum;
    @OneToOne
    private Kurs kurs;
//    @OneToOne
//    private Lehre lehre;
    private Boolean vertretung;
    @OneToMany
    private List<StundenPlanDetails> details;

    public StundenPlan() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Time getBeginn() {
        return beginn;
    }

    public void setBeginn(Time beginn) {
        this.beginn = beginn;
    }

    public Time getEnde() {
        return ende;
    }

    public void setEnde(Time ende) {
        this.ende = ende;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public Kurs getKurs() {
        return kurs;
    }

    public void setKurs(Kurs kurs) {
        this.kurs = kurs;
    }



    public Boolean getVertretung() {
        return vertretung;
    }

    public void setVertretung(Boolean vertretung) {
        this.vertretung = vertretung;
    }

    public List<StundenPlanDetails> getDetail() {
        return details;
    }

    public void setDetail(List<StundenPlanDetails> details) {
        this.details = details;
    }
}
