package com.educom.server.auth.jwt.model;

import com.educom.server.entity.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "educom_user")
public class EducomUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   // @Column(nullable = false,length = 50)
//    private String firstname;
//    @Column(nullable = false,length = 50)
//    private String lastname;
    @Column(nullable = false,length = 50)
    private String userName;
    @Column(nullable = false,length = 120,unique = true)
    private String email;
    @Column(nullable = false,unique = true)
    private String password;
    private boolean active;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public EducomUser() {
    }

    public EducomUser(String userName, String email, String password, boolean active) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.active = active;

    }

    public EducomUser(String userName, String email, String password, boolean active, Set<Role> roles) {

        this.userName = userName;
        this.email = email;
        this.password = password;
        this.active = active;
        this.roles = roles;
    }

//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "EducomUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", roles='" + roles + '\'' +
                '}';
    }
}
