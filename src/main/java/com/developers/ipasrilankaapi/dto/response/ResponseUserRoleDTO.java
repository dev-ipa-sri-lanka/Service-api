package com.developers.ipasrilankaapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseUserRoleDTO {
    private String roleId;
    private String roleName;
    private String description;
    private boolean activeState;
}
