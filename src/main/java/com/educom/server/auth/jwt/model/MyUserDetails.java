package com.educom.server.auth.jwt.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;


    public MyUserDetails(String userName, String password, boolean active, List<GrantedAuthority> authorities) {
        this.userName = userName;
        this.password = password;
        this.active = active;
        this.authorities = authorities;
    }

    public static MyUserDetails build(EducomUser user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());

        return new MyUserDetails(
                user.getUserName(),
                user.getPassword(),
                user.isActive(),
                authorities);
    }

    public MyUserDetails(String userName){
        this.userName=userName;
    }

    public MyUserDetails() {
    }

    public MyUserDetails(EducomUser educomUser) {
        this.userName= educomUser.getUserName();
        this.password= educomUser.getPassword();
        this.active= educomUser.isActive();
      //  this.authorities=Arrays.stream(educomUser.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
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

    @Override
    public List<GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
