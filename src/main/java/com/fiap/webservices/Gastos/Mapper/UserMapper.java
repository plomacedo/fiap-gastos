package com.fiap.webservices.Gastos.Mapper;

import com.fiap.webservices.Gastos.DTO.UserDTO;
import com.fiap.webservices.Gastos.Model.User;

public class UserMapper {

    public static UserDTO maptoUserDTO(User user){
        UserDTO userDTO = new UserDTO(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
        return userDTO;
    }

    public static User mapToUser (UserDTO userDTO){
        User user = new User(
                userDTO.getId(),
                userDTO.getName(),
                userDTO.getEmail()
        );
        return user;
    }

}
