package com.car_repair_shop.dtos.userDTO;

import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.domain.user.UserType;

public record UserDTO(String login, String password, UserType role) {
    public UserDTO(User user){
        this(user.getLogin(), user.getPassword(), user.getRole());
    }
}
