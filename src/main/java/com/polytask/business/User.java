package com.polytask.business;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name="username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private int enabled;

    public User(){

    }

    public User(String username, String password){
        this.username = username;
        this.password = password;
        this.enabled = 1;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getHashPassword() {
        String hash = new BCryptPasswordEncoder().encode(this.password);
        return hash;
    }

}
