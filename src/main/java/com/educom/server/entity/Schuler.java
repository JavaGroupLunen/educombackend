package com.educom.server.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="schuler")
public class Schuler extends Person  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String vater;
    private String mutter;

    @OneToMany(fetch = FetchType.LAZY)
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

    public Schuler(String firstName, String lastName, String email, @Size(max = 15) String phoneNumber, Gender gender, Date geburstDatum, @Size(max = 200) String address, @Size(max = 100) String stadt, @Size(max = 100) String land, @Size(max = 32) String plz, Long personTypeId) {
        super(firstName, lastName, email, phoneNumber, gender, geburstDatum, address, stadt, land, plz, personTypeId);
    }

    public Schuler() {
    }

    public Schuler(String vater, String mutter, Schule schule, Set<Kurs> kurses) {
        this.vater = vater;
        this.mutter = mutter;
        this.schule = schule;
        this.kurses = kurses;
    }

    public Schuler(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


}
