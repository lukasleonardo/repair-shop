package com.car_repair_shop.service;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.carDTO.CarResponseDTO;
import com.car_repair_shop.exception.CarNotFoundException;
import com.car_repair_shop.exception.OwnerNotFoundException;
import jakarta.transaction.Transactional;
import com.car_repair_shop.domain.service_order.ServiceOrder;
import com.car_repair_shop.dtos.serviceOrderDTO.ServiceOrderRequestDTO;
import com.car_repair_shop.repository.ServiceOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;

@Service
public class ServiceOrderService {

    @Autowired
    private ServiceOrderRepository serviceOrderRepository;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private CarService carService;

    @Transactional
    public ServiceOrder createServiceOrder(ServiceOrderRequestDTO serviceOrderRequestDTO) throws Exception {
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDescription(serviceOrderRequestDTO.description());
        serviceOrder.setInitialDate(LocalDate.now());

        Owner owner = ownerService.findOwnerById(serviceOrderRequestDTO.owner_id());
        serviceOrder.setOwner(owner);

        CarResponseDTO carDTO = carService.findCarById(serviceOrderRequestDTO.car_id());

        Car car = new Car(carDTO);
        serviceOrder.setCar(car);

        return  serviceOrder;
    }

    public ServiceOrder FindById(Long id) throws Exception {
        ServiceOrder serviceOrder = this.serviceOrderRepository.findById(id).orElseThrow(()-> new Exception("Ordem de serviço não Encontrada"));
        return serviceOrder;
    }

    public List<ServiceOrder> FindAll(){
        return this.serviceOrderRepository.findAll();
    }


    public void deleteOrderById(Long id){
        this.serviceOrderRepository.deleteById(id);
    }





}
