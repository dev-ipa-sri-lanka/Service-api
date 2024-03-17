package com.developers.ipasrilankaapi.entity;

import com.vladmihalcea.hibernate.type.json.JsonStringType;
import lombok.*;

import javax.persistence.*;
import org.hibernate.annotations.TypeDef;

import java.io.Serializable;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "user_role_has_user")
@TypeDef(name = "json", typeClass = JsonStringType.class)
public class UserRoleHasUser implements Serializable {

    @EmbeddedId
    private UserRoleHasUserKey id =
    new UserRoleHasUserKey() ;

    @ManyToOne
    @MapsId("user")
    @JoinColumn(name = "user_id", nullable = false)
    User user;


    @ManyToOne
    @MapsId("userRole")
    @JoinColumn(name = "role_id", nullable = false)
    UserRole userRole;


    public UserRoleHasUser(String userId, String roleId) {
    }
}
