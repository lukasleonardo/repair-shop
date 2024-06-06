package com.car_repair_shop.service;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.CarDTO;
import com.car_repair_shop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerService ownerService;


    public Car createCar(CarDTO carDTO) throws Exception {

        Car car = new Car();
        car.setBrand(carDTO.brand());
        car.setModel(carDTO.model());
        car.setPlate(carDTO.plate());
        car.setColor(carDTO.color());
        Owner ownerOptional = ownerService.findOwnerById(carDTO.owner_id());
        if (ownerOptional!=null) {
            car.setOwner(ownerOptional);
        } else {
            throw new RuntimeException("Proprietário não encontrado");
        }
        return car;
    }

    public Car findCarById(Long id) throws Exception {
        Car car = this.carRepository.findById(id).orElseThrow(()->new Exception("Carro não Encontrado!"));
        return car;
    }

}
