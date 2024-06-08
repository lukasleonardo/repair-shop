package com.car_repair_shop.dtos.ownerDTO;

import com.car_repair_shop.domain.car.Car;

import java.util.List;

public record OwnerRequestDTO(String name, String phone, String address, List<Car> cars ) {
}
