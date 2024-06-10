package com.car_repair_shop.controller;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.dtoMappers.CarDTOMapper;
import com.car_repair_shop.dtos.carDTO.CarRequestDTO;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;
import com.car_repair_shop.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping
    public ResponseEntity<CarResponseDTO> createCar(@RequestBody CarRequestDTO carRequestDTO){
        Car car = this.carService.createCar(carRequestDTO);
        CarResponseDTO carResponse = CarDTOMapper.toDTO(car);
        return ResponseEntity.ok(carResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponseDTO> findCarById(@PathVariable Long id){
        Car car =this.carService.findCarById(id);
        CarResponseDTO carResponse = CarDTOMapper.toDTO(car);
        return ResponseEntity.ok(carResponse);
    }

    @GetMapping
    public ResponseEntity<List<CarResponseDTO>> findAllCars(){
      List<CarResponseDTO>  cars = this.carService.findAllCars();
      return ResponseEntity.ok(cars);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        this.carService.deleteById(id);
    }
}
