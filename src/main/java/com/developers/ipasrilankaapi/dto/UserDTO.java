package com.developers.ipasrilankaapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserDTO implements SuperDTO{

    private String userId;

    private boolean activeState;

    private String email;

    private String firstName;

    private String lastName;

    private boolean isAccountNonExpired;

    private boolean isAccountNonLocked;

    private boolean isCredentialsNonExpired;

    private boolean isEnabled;

    private int otp;

    private String password;

    private String prefix;

    private Date registerDate;

    private String username;

}
