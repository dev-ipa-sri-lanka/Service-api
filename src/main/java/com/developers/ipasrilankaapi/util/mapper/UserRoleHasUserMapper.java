package com.developers.ipasrilankaapi.util.mapper;

import com.developers.ipasrilankaapi.dto.UserRoleHasUserDTO;
import com.developers.ipasrilankaapi.entity.UserRoleHasUser;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleHasUserMapper {
    UserRoleHasUser toUserRoleHasUser(UserRoleHasUserDTO userRoleHasUser);
}
