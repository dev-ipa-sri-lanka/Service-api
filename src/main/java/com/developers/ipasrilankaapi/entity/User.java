package com.developers.ipasrilankaapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(length = 80, name = "user_id")
    private String userId;

    @Column(name = "active_state", columnDefinition = "TINYINT")
    private boolean activeState;

    @Column(length = 250, name = "email", unique = true)
    private String email;

    @Column(length = 45, name = "first_name")
    private String firstName;

    @Column(length = 45, name = "last_name")
    private String lastName;

    @Column(name = "is_account_non_expired", columnDefinition = "TINYINT")
    private boolean isAccountNonExpired;

    @Column(name = "is_account_non_locked", columnDefinition = "TINYINT")
    private boolean isAccountNonLocked;

    @Column(name = "is_credentials_non_expired", columnDefinition = "TINYINT")
    private boolean isCredentialsNonExpired;

    @Column(name = "is_enabled", columnDefinition = "TINYINT")
    private boolean isEnabled;

    @Column(length = 10, name = "otp")
    private int otp;

    @Column(length = 750, name = "password")
    private String password;

    @Column(length = 45, name = "prefix")
    private String prefix;

    @Column(name = "register_date")
    private Date registerDate;

    @Column(length = 250, name = "user_name", unique = true)
    private String username;


//    -----------  Mappings ---------------


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<UserRoleHasUser> userRoleHasUsers;
}