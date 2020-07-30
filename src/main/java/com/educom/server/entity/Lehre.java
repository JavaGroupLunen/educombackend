package com.educom.server.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="lehre")
public class Lehre {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        @Column(name = "first_name", nullable = false)
        private String firstName;
        @Column(name = "last_name", nullable = false)
        private String lastName;
        @Column(name = "email_address", nullable = false)
        private String emailId;
        @ManyToMany
        private List<Kurs> kursList;

    public List<Kurs> getKursList() {
        return kursList;
    }

    public void setKursList(List<Kurs> kursList) {
        this.kursList = kursList;
    }

    public Lehre(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public Lehre() {
    }

    public Lehre(Object value) {
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
