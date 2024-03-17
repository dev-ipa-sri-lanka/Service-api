package com.developers.ipasrilankaapi.entity;

import javax.persistence.*;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class UserRoleHasUserKey implements Serializable {
    @Column(length = 80, name = "user_id")
    private String user;

    @Column(length = 45, name = "role_id")
    private String userRole;
}
