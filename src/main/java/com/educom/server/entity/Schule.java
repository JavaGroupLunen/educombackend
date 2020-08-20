package com.educom.server.entity;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name="schule")
public class Schule  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "schule_name", nullable = false)
    private String name;
    @Transient
    @OneToMany(mappedBy = "schule", fetch = FetchType.EAGER)
    private List<Schuler> Schulerlist = new LinkedList<>();

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

    public List<Schuler> getSchulerlist() {
        return Schulerlist;
    }

    public void setSchulerlist(List<Schuler> schulerlist) {
        Schulerlist = schulerlist;
    }
}
