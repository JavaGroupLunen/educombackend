package com.educom.server.entity;



import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="schuler")
public class Schuler extends Person{
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    //private long id;
    private String vater;
    private String mutter;
    private String klasse;

    @ManyToOne
    @JoinColumn(name = "schule_id")
    private  Schule schule;


    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(
            name = "schuler_kurs",
            joinColumns = { @JoinColumn(name = "schuler_id") },
            inverseJoinColumns = { @JoinColumn(name = "kurs_id") }
    )
    private Set<Kurs> kurses = new HashSet<>();

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getKlasse() {
        return klasse;
    }

    public void setKlasse(String klasse) {
        this.klasse = klasse;
    }

    public String getVater() {
  return vater;
 }

 public void setVater(String vater) {
  this.vater = vater;
 }

 public String getMutter() {
  return mutter;
 }

 public void setMutter(String mutter) {
  this.mutter = mutter;
 }

 public Schule getSchule() {
  return schule;
 }

 public void setSchule(Schule schule) {
  this.schule = schule;
 }

 public Set<Kurs> getKurses() {
  return kurses;
 }

 public void setKurses(Set<Kurs> kurses) {
  this.kurses = kurses;
 }

 public Schuler() {
    }

    @Override
    public String toString() {
        return "Schuler{" +
                "vater='" + vater + '\'' +
                ", mutter='" + mutter + '\'' +
                ", schule=" + schule +
                ", kurses=" + kurses +
                ", id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", gender=" + gender +
                ", geburstDatum=" + geburstDatum +
                ", adres='" + adresse + '\'' +
                ", stadt='" + stadt + '\'' +
                ", land='" + land + '\'' +
                ", plz='" + plz + '\'' +
                '}';
    }
}
