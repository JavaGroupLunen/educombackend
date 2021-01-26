package com.educom.server.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
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
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate anfangab;
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private LocalDate endebis;
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

}
