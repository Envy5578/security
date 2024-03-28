package com.focus_group.security.mapper;

import com.focus_group.security.dto.UserDTO;
import com.focus_group.security.entities.UserEntity;

public class UserMapper {
    public static UserDTO toDTO(UserEntity user) {
        return new UserDTO(user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
