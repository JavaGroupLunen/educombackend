package com.educom.server.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "vertrag")
public class Vertrag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date vertragsdatum;
    private LocalDate vertragsbegin;
    private LocalDate vertragsende;
    private ZahlungsType zahlungstype;
    private Double einmaligeKosten;
    private Double anmeldegebuhr;
    private Double materialprice;
    private Double summe;
    private Double monatlischeRate;
    private Double restbetrag;
    private int rabat;
    private int rabatPercent;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "vertrag_schueler",
            joinColumns =
                    { @JoinColumn(name = "vertrag_id", referencedColumnName = "id") },
            inverseJoinColumns =
                    { @JoinColumn(name = "schuler_id", referencedColumnName = "id") })
    private Schuler schuler;


    public Vertrag(long id, Date vertragsdatum, ZahlungsType zahlungstype, Double einmaligeKosten, Double anmeldegebuhr, Double materialprice, Double summe, Double monatlischeRate, Double restbetrag, int rabat, int rabatPercent, Schuler schuler) {
        this.id = id;
        this.vertragsdatum = vertragsdatum;
        this.zahlungstype = zahlungstype;
        this.einmaligeKosten = einmaligeKosten;
        this.anmeldegebuhr = anmeldegebuhr;
        this.materialprice = materialprice;
        this.summe = summe;
        this.monatlischeRate = monatlischeRate;
        this.restbetrag = restbetrag;
        this.rabat = rabat;
        this.rabatPercent = rabatPercent;
        this.schuler = schuler;

    }

    public Vertrag() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVertragsdatum() {
        return vertragsdatum;
    }

    public void setVertragsdatum(Date vertragsdatum) {
        this.vertragsdatum = vertragsdatum;
    }

    public LocalDate getVertragsbegin() {
        return vertragsbegin;
    }

    public void setVertragsbegin(LocalDate vertragsbegin) {
        this.vertragsbegin = vertragsbegin;
    }

    public LocalDate getVertragsende() {
        return vertragsende;
    }

    public void setVertragsende(LocalDate vertragsende) {
        this.vertragsende = vertragsende;
    }

    public ZahlungsType getZahlungstype() {
        return zahlungstype;
    }

    public void setZahlungstype(ZahlungsType zahlungstype) {
        this.zahlungstype = zahlungstype;
    }

    public Double getEinmaligeKosten() {
        return einmaligeKosten;
    }

    public void setEinmaligeKosten(Double einmaligeKosten) {
        this.einmaligeKosten = einmaligeKosten;
    }

    public Double getAnmeldegebuhr() {
        return anmeldegebuhr;
    }

    public void setAnmeldegebuhr(Double anmeldegebuhr) {
        this.anmeldegebuhr = anmeldegebuhr;
    }

    public Double getMaterialprice() {
        return materialprice;
    }

    public void setMaterialprice(Double materialprice) {
        this.materialprice = materialprice;
    }

    public Double getSumme() {
        return summe;
    }

    public void setSumme(Double totalprice) {
        this.summe = totalprice;
    }

    public Double getMonatlischeRate() {
        return monatlischeRate;
    }

    public void setMonatlischeRate(Double monatlischeRate) {
        this.monatlischeRate = monatlischeRate;
    }

    public Double getRestbetrag() {
        return restbetrag;
    }

    public void setRestbetrag(Double restbetrag) {
        this.restbetrag = restbetrag;
    }

    public int getRabat() {
        return rabat;
    }

    public void setRabat(int rabat) {
        this.rabat = rabat;
    }

    public int getRabatPercent() {
        return rabatPercent;
    }

    public void setRabatPercent(int rabatPercent) {
        this.rabatPercent = rabatPercent;
    }

    public Schuler getSchuler() {
        return schuler;
    }

    public void setSchuler(Schuler schuler) {
        this.schuler = schuler;
    }

    @Override
    public String toString() {
        return "Vertrag{" +
                "id=" + id +
                ", vertragsdatum=" + vertragsdatum +
                ", vertragsbegin=" + vertragsbegin +
                ", vertragsende=" + vertragsende +
                ", zahlungstype=" + zahlungstype +
                ", einmaligeKosten=" + einmaligeKosten +
                ", anmeldegebuhr=" + anmeldegebuhr +
                ", materialprice=" + materialprice +
                ", summe=" + summe +
                ", monatlischeRate=" + monatlischeRate +
                ", restbetrag=" + restbetrag +
                ", rabat=" + rabat +
                ", rabatPercent=" + rabatPercent +
                ", schuler=" + schuler +
                '}';
    }
}
