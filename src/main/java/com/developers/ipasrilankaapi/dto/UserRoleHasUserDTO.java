package com.developers.ipasrilankaapi.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;



@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class UserRoleHasUserDTO {

    UserDTO user;

    UserRoleDTO userRole;
}
