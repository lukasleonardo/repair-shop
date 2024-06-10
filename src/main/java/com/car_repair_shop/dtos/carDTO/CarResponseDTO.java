package com.car_repair_shop.dtos.carDTO;

import com.car_repair_shop.domain.car.Car;

public record CarResponseDTO(Long id, String plate, String color, String brand, String model, Long owner_id) {
    public CarResponseDTO(Car car) {
        this(
        car.getId(),
        car.getPlate(),
        car.getColor(),
        car.getBrand(),
        car.getModel(),
        car.getOwner().getId()
        );
    }
}
