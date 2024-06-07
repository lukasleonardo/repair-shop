package com.car_repair_shop.dtos.carDTO;


public record CarRequestDTO(String plate, String color, String brand, String model, Long owner_id) {
    @Override
    public String plate() {
        return plate;
    }

    @Override
    public String color() {
        return color;
    }

    @Override
    public String brand() {
        return brand;
    }

    @Override
    public String model() {
        return model;
    }

    @Override
    public Long owner_id() {
        return owner_id;
    }

}
