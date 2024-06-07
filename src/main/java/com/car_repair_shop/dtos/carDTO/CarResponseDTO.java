package com.car_repair_shop.dtos.carDTO;

import com.car_repair_shop.domain.car.Car;

public record CarResponseDTO(Long id, String plate, String color, String brand, String model, Long owner_id) {
    public CarResponseDTO(Long id, String plate, String color, String brand, String model, Long owner_id) {
        this.id = id;
        this.plate = plate;
        this.color = color;
        this.brand = brand;
        this.model = model;
        this.owner_id = owner_id;
    }
}
