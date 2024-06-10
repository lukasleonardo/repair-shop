package com.car_repair_shop.dtos.ownerDTO;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public record OwnerResponseDTO(Long id, String name, String phone, String address, List<CarResponseDTO> cars) {

    public OwnerResponseDTO(Owner owner) {
        this(
                owner.getId(),
                owner.getName(),
                owner.getPhone(),
                owner.getAddress(),
                owner.getCars().stream().map(CarResponseDTO::new).collect(Collectors.toList())
        );
    }

}
