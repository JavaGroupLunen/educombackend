package com.educom.server.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lehre")
public class Lehre extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected long id;
    private Double stundenLohn;
    @ManyToOne(fetch= FetchType.EAGER)
    @JoinColumn()
    private VerfugbarkeitFurLehre verfugbarkeitFurLehre;
    @OneToMany()
    private List<Kurs> kanngeben;

    public Lehre(Double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public Lehre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getStundenLohn() {
        return stundenLohn;
    }

    public void setStundenLohn(Double stundenLohn) {
        this.stundenLohn = stundenLohn;
    }

    public VerfugbarkeitFurLehre getVerfugbarkeitFurLehre() {
        return verfugbarkeitFurLehre;
    }

    public void setVerfugbarkeitFurLehre(VerfugbarkeitFurLehre verfugbarkeitFurLehre) {
        this.verfugbarkeitFurLehre = verfugbarkeitFurLehre;
    }

    public List<Kurs> getKanngeben() {
        return kanngeben;
    }

    public void setKanngeben(List<Kurs> kanngeben) {
        this.kanngeben = kanngeben;
    }
}
