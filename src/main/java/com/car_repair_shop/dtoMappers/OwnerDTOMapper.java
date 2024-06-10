package com.car_repair_shop.dtoMappers;


import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;
import com.car_repair_shop.dtos.ownerDTO.OwnerResponseDTO;

import java.util.stream.Collectors;

public class OwnerDTOMapper {

    public static OwnerResponseDTO toDTO(Owner owner) {
        return new OwnerResponseDTO(
                owner.getId(),
                owner.getName(),
                owner.getPhone(),
                owner.getAddress(),
                owner.getCars().stream().map(CarResponseDTO::new).collect(Collectors.toList())

        );
    }

}
