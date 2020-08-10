package com.educom.server.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="verfugbarkeit_fur_lehre")
public class VerfugbarkeitFurLehre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date verfugbaerkeitZeitAb;
    private Date verfugberkeitZeitBis;
    private Date verfugbarDatumAb;
    private Date verfugbarDatumBis;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn()
    private Lehre lehre;

    public VerfugbarkeitFurLehre(Date verfugbaerkeitZeitAb, Date verfugberkeitZeitBis, Date verfugbarDatumAb, Date verfugbarDatumBis) {
        this.verfugbaerkeitZeitAb = verfugbaerkeitZeitAb;
        this.verfugberkeitZeitBis = verfugberkeitZeitBis;
        this.verfugbarDatumAb = verfugbarDatumAb;
        this.verfugbarDatumBis = verfugbarDatumBis;
    }

    public VerfugbarkeitFurLehre() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getVerfugbaerkeitZeitAb() {
        return verfugbaerkeitZeitAb;
    }

    public void setVerfugbaerkeitZeitAb(Date verfugbaerkeitZeitAb) {
        this.verfugbaerkeitZeitAb = verfugbaerkeitZeitAb;
    }

    public Date getVerfugberkeitZeitBis() {
        return verfugberkeitZeitBis;
    }

    public void setVerfugberkeitZeitBis(Date verfugberkeitZeitBis) {
        this.verfugberkeitZeitBis = verfugberkeitZeitBis;
    }

    public Date getVerfugbarDatumAb() {
        return verfugbarDatumAb;
    }

    public void setVerfugbarDatumAb(Date verfugbarDatumAb) {
        this.verfugbarDatumAb = verfugbarDatumAb;
    }

    public Date getVerfugbarDatumBis() {
        return verfugbarDatumBis;
    }

    public void setVerfugbarDatumBis(Date verfugbarDatumBis) {
        this.verfugbarDatumBis = verfugbarDatumBis;
    }

    public Lehre getLehre() {
        return lehre;
    }

    public void setLehre(Lehre lehre) {
        this.lehre = lehre;
    }
}
