package com.educom.server.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="kurs")
public class Kurs {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "raum", nullable = true)
    private String raum;
    @OneToOne
    private Lehre lehre;
    @ManyToMany
    private List<Schuler> schulerList;

    public Kurs(String name, String raum, Lehre lehre, List<Schuler> schulerList) {
        this.name = name;
        this.raum = raum;
        this.lehre = lehre;
        this.schulerList = schulerList;
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

    public Lehre getLehre() {
        return lehre;
    }

    public void setLehre(Lehre lehre) {
        this.lehre = lehre;
    }

    public List<Schuler> getSchulerList() {
        return schulerList;
    }

    public void setSchulerList(List<Schuler> schulerList) {
        this.schulerList = schulerList;
    }
}
