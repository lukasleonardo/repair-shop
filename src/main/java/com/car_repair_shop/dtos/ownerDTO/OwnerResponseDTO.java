package com.car_repair_shop.dtos.ownerDTO;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;

import java.util.List;

public record OwnerResponseDTO(Long id, String name, String phone, String address, List<Car> cars) {

    public OwnerResponseDTO(Owner owner) {
        this(owner.getId(), owner.getName(), owner.getAddress(), owner.getPhone(), owner.getCars());
    }

}
