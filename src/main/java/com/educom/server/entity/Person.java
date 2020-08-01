package com.educom.server.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "person")
public class Person  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @NotNull
    @Column(unique = true)
    private String email;
    @Column(name = "phone_number")
    @Size(max = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    @Column(name = "geburst_datum")
    private Date geburstDatum;

    @Size(max = 200)
    private String address;

    @Size(max = 100)
    private String stadt;

    @Size(max = 100)
    private String land;

    @Column(name = "plz")
    @Size(max = 32)
    private String plz;

    private String vater;
    private String mutter;

    public Person(String firstName, String lastName, String email, @Size(max = 15) String phoneNumber, Gender gender, Date geburstDatum, @Size(max = 200) String address, @Size(max = 100) String stadt, @Size(max = 100) String land, @Size(max = 32) String plz, String vater, String mutter) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.geburstDatum = geburstDatum;
        this.address = address;
        this.stadt = stadt;
        this.land = land;
        this.plz = plz;
        this.vater = vater;
        this.mutter = mutter;
    }

    public Person(String firstName, String lastName, String emailId) {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getGeburstDatum() {
        return geburstDatum;
    }

    public void setGeburstDatum(Date geburstDatum) {
        this.geburstDatum = geburstDatum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
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
}
