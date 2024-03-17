package com.developers.ipasrilankaapi.util.mapper;

import com.developers.ipasrilankaapi.dto.UserRoleDTO;
import com.developers.ipasrilankaapi.dto.response.ResponseUserRoleDTO;
import com.developers.ipasrilankaapi.entity.UserRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {
    UserRoleDTO toUserRoleDto(UserRole userRole);

    UserRole toUserRole(UserRoleDTO userRoleDTO);

    ResponseUserRoleDTO toResponseUserRoleDto(UserRole userRole);
}
