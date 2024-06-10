package com.car_repair_shop.dtoMappers;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;


public class CarDTOMapper {

        public static CarResponseDTO toDTO(Car car) {
            return new CarResponseDTO(
                    car.getId(),
                    car.getPlate(),
                    car.getBrand(),
                    car.getModel(),
                    car.getColor(),
                    car.getOwner().getId()
            );
        }

}
