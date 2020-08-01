package com.educom.server.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="schuler")
public class Schuler {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "email_address", nullable = false)
    private String emailId;
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

    public Schuler(String firstName, String lastName, String emailId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
    }

    public Schuler(String firstName, String lastName, String emailId, Set<Kurs> kurses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.kurses = kurses;
    }

    public Schuler() {
    }

    public Set<Kurs> getKurses() {
        return kurses;
    }

    public void setKurses(Set<Kurs> kurses) {
        this.kurses = kurses;
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
