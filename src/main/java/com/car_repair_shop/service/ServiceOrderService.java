package com.car_repair_shop.service;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import com.car_repair_shop.dtos.serviceOrderDTO.ServiceOrderResponseDTO;
import com.car_repair_shop.exception.NotFoundException;
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
    public ServiceOrder createServiceOrder(ServiceOrderRequestDTO serviceOrderRequestDTO) throws NotFoundException {

        Owner owner= ownerService.findOwnerById(serviceOrderRequestDTO.owner_id());
        Car car = carService.findCarById(serviceOrderRequestDTO.car_id());

        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setDescription(serviceOrderRequestDTO.description());
        serviceOrder.setInitialDate(LocalDate.now());
        serviceOrder.setOwner(owner);
        serviceOrder.setCar(car);
        //ADICIONAR PREVIMAGES ???

        return this.serviceOrderRepository.save(serviceOrder);
    }

    public ServiceOrder FindOrderById(Long id) throws NotFoundException {
        return this.serviceOrderRepository.findById(id).orElseThrow(()-> new NotFoundException("Ordem de serviço não Encontrada"));
    }

    public List<ServiceOrderResponseDTO> FindAllOrders(){
        return this.serviceOrderRepository.findAll().stream().map(ServiceOrderResponseDTO::new).toList();
    }


    public void deleteOrderById(Long id){
        this.serviceOrderRepository.deleteById(id);
    }





}
