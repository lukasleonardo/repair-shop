package com.car_repair_shop.dtos.carDTO;

import com.car_repair_shop.domain.car.Car;

public record CarResponseDTO(Long id, String plate, String brand, String model, String color, Long owner_id) {
    public CarResponseDTO(Car car) {
        this(
        car.getId(),
        car.getPlate(),
        car.getBrand(),
        car.getModel(),
        car.getColor(),
        car.getOwner().getId()
        );
    }
}
