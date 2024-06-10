package com.car_repair_shop.service;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.carDTO.CarRequestDTO;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;
import com.car_repair_shop.exception.NotFoundException;
import com.car_repair_shop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerService ownerService;


    public Car createCar(CarRequestDTO carRequestDTO) throws NotFoundException {
        Owner owner = this.ownerService.findOwnerById(carRequestDTO.owner_id());
        Car car = new Car(carRequestDTO,owner);
        return this.carRepository.save(car);
    }

    public Car findCarById(Long id) throws NotFoundException {
        return this.carRepository.findById(id).orElseThrow(()-> new NotFoundException("Carro não encontrado com ID: "+id));
    }

    public List<CarResponseDTO> findAllCars(){
        return this.carRepository.findAll().stream().map(CarResponseDTO::new).toList();
    }

    public void deleteById(Long id) {
        this.carRepository.deleteById(id);
    }
}
