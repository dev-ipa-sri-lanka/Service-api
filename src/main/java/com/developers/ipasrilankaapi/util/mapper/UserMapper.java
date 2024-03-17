package com.developers.ipasrilankaapi.util.mapper;


import com.developers.ipasrilankaapi.dto.UserDTO;
import com.developers.ipasrilankaapi.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDto(User user);

    User toUser(UserDTO userDTO);
}
