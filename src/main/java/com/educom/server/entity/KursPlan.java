package com.educom.server.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="kurs_plan")
public class KursPlan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String raumNummer;
    private Long  kursId;
    private Long lehreId;

}
