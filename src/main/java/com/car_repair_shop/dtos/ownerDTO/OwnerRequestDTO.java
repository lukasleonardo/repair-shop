package com.car_repair_shop.dtos.ownerDTO;

import com.car_repair_shop.domain.car.Car;

import java.util.List;

public record OwnerRequestDTO( Long id, String name, String phone, String address, List<Car> cars ) {

    @Override
    public Long id() {
        return id;
    }

    @Override
    public String phone() {
        return phone;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String address() {
        return address;
    }

    @Override
    public List<Car> cars() {
        return cars;
    }

}
