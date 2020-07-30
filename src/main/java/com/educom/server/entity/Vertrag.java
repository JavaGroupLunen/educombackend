package com.educom.server.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="vertrag")
public class Vertrag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date  vertragDatum;
    @OneToOne
    private Schuler schuler;
    @ManyToMany
    private List<Kurs> kursList;

    public Vertrag(Date vertragDatum, Schuler schuler, List<Kurs> kursList) {
        this.vertragDatum = vertragDatum;
        this.schuler = schuler;
        this.kursList = kursList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVertragDatum() {
        return vertragDatum;
    }

    public void setVertragDatum(Date vertragDatum) {
        this.vertragDatum = vertragDatum;
    }

    public Schuler getSchuler() {
        return schuler;
    }

    public void setSchuler(Schuler schuler) {
        this.schuler = schuler;
    }

    public List<Kurs> getKursList() {
        return kursList;
    }

    public void setKursList(List<Kurs> kursList) {
        this.kursList = kursList;
    }
}
