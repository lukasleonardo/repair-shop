package com.car_repair_shop.dtos.userDTO;

import com.car_repair_shop.domain.user.UserType;

public record UserRequestDTO(String login,String password, UserType role) {
    @Override
    public String login() {
        return login;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public UserType role() {
        return role;
    }
}
