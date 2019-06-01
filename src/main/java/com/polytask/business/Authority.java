package com.polytask.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="authorities")
public class Authority {
    @Id
    @Column(name="username")
    private String username;
    @Column(name="authority")
    private String authority;

    public Authority(){

    }

    public Authority(String username) {
        this.username = username;
        this.authority = "user";
    }

    public String getUsername() {
        return username;
    }

    public String getAuthority() {
        return authority;
    }
}
