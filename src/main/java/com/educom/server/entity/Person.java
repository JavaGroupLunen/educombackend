package com.educom.server.entity;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;


@MappedSuperclass
public abstract class  Person {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private long id;
   private  String firstName;
   private  String lastName ;
   private  String email;

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


    private String phoneNumber;

    @Enumerated(EnumType.STRING)

    private Gender gender;

    @Temporal(TemporalType.DATE)

    private Date geburstDatum;


    private String address;


    private String stadt;


    private String land;


    private String plz;


}
