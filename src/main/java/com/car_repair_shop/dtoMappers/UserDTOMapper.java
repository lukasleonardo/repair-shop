package com.car_repair_shop.dtoMappers;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.carDTO.CarRequestDTO;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;


public class UserDTOMapper {
        public static Car toEntity(CarRequestDTO carRequestDTO, Owner owner) {
            Car car = new Car();
            car.setBrand(carRequestDTO.brand());
            car.setModel(carRequestDTO.model());
            car.setPlate(carRequestDTO.plate());
            car.setColor(carRequestDTO.color());
            car.setOwner(owner);
            return car;
        }

        public static CarResponseDTO toDTO(Car car) {
            CarResponseDTO carResponseDTO = new CarResponseDTO(
                    car.getId(),
                    car.getBrand(),
                    car.getModel(),
                    car.getPlate(),
                    car.getColor(),
                    car.getOwner().getId()
            );
            return carResponseDTO;
        }

}
