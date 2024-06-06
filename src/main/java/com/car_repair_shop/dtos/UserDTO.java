package com.car_repair_shop.dtos;

import com.car_repair_shop.domain.user.UserType;

public record UserDTO(String login, String password, UserType role) {
}
