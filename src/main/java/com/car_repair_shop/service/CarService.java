package com.car_repair_shop.service;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtoMappers.UserDTOMapper;
import com.car_repair_shop.dtos.carDTO.CarRequestDTO;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;
import com.car_repair_shop.exception.CarNotFoundException;
import com.car_repair_shop.exception.OwnerNotFoundException;
import com.car_repair_shop.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private OwnerService ownerService;


    public CarResponseDTO createCar(CarRequestDTO carRequestDTO) throws Exception {

        Owner owner = ownerService.findOwnerById(carRequestDTO.owner_id());

        Car car = UserDTOMapper.toEntity(carRequestDTO,owner);
        carRepository.save(car);

        return UserDTOMapper.toDTO(car);
    }

    public CarResponseDTO findCarById(Long id) throws Exception {
        Car car = this.carRepository.findById(id).orElseThrow(CarNotFoundException::new);
        return UserDTOMapper.toDTO(car);
    }

}


/*Owner owner = ownerService.findOwnerById(carRequestDTO.owner_id());
        if(owner == null){
          throw new Exception("Proprietário não encontrado");
        }*/