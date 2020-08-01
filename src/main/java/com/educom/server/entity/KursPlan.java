package com.educom.server.entity;

import javax.persistence.*;

@Entity
@Table(name="kurs_plan")
public class KursPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String raumNummer;
    private Long  kursId;
    private Long lehreId;

}
