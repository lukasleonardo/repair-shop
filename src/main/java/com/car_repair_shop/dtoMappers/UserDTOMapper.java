package com.car_repair_shop.dtoMappers;


import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.dtos.userDTO.UserResponseDTO;

public class UserDTOMapper {

    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getLogin(),
                user.getPassword(),
                user.getRole()
        );
    }

}
