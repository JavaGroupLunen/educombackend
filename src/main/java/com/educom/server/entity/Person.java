package com.educom.server.entity;




import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;


@MappedSuperclass
public abstract class  Person implements Serializable {
    protected  String firstName;
    protected  String lastName ;
    protected  String email;
    protected String phoneNumber;
    @Enumerated(EnumType.STRING)
    protected Gender gender;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    protected LocalDate geburstDatum;
    protected String adresse;
    protected String stadt;
    protected String land;
    protected String plz;
    protected String pictureurl;

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
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

    public LocalDate getGeburstDatum() {
        return geburstDatum;
    }

    public void setGeburstDatum(LocalDate geburstDatum) {
        this.geburstDatum = geburstDatum;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adres) {
        this.adresse = adres;
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

}
