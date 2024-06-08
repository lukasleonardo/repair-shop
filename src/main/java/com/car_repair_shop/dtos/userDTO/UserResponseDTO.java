package com.car_repair_shop.dtos.userDTO;

import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.domain.user.UserType;

public record UserResponseDTO(Long id, String login, String password, UserType role) {

    public UserResponseDTO(User user){
        this( user.getId(),
        user.getLogin(),
        user.getPassword(),
        user.getRole());
    }


}
/*
    public UserResponseDTO(Long id, String login, String password, UserType role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;

    }*/