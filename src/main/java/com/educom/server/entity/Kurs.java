package com.educom.server.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="kurs")
public class Kurs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "raum", nullable = true)
    private String raum;
    private Double kosten;
    private int dauer;
    private int kurslang;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate anfangAb;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate endeBis;
    @Enumerated(EnumType.STRING)
    private KursType kurstype;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn()
    private Lehre lehre;
    @ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            },mappedBy = "kurses")
    private Set<Schuler> schulerSet = new HashSet<>();

    public Kurs(String name, String raum, Lehre lehre) {
        this.name = name;
        this.raum = raum;
        this.lehre = lehre;
       
    }

    public Kurs() {
    }

    public Kurs(String name, String raum) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public Double getKosten() {
        return kosten;
    }

    public void setKosten(Double kosten) {
        this.kosten = kosten;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getKurslang() {
        return kurslang;
    }

    public void setKurslang(int kurslang) {
        this.kurslang = kurslang;
    }

    public LocalDate getAnfangAb() {
        return anfangAb;
    }

    public void setAnfangAb(LocalDate anfangAb) {
        this.anfangAb = anfangAb;
    }

    public LocalDate getEndeBis() {
        return endeBis;
    }

    public void setEndeBis(LocalDate endeBis) {
        this.endeBis = endeBis;
    }

    public KursType getKurstype() {
        return kurstype;
    }

    public void setKurstype(KursType kurstype) {
        this.kurstype = kurstype;
    }

    public Lehre getLehre() {
        return lehre;
    }

    public void setLehre(Lehre lehre) {
        this.lehre = lehre;
    }

    public Set<Schuler> getSchulerSet() {
        return schulerSet;
    }

    public void setSchulerSet(Set<Schuler> schulerSet) {
        this.schulerSet = schulerSet;
    }
}
