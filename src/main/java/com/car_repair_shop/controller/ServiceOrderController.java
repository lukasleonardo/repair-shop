package com.car_repair_shop.controller;

import com.car_repair_shop.domain.service_order.ServiceOrder;
import com.car_repair_shop.dtoMappers.ServiceOrderDTOMapper;
import com.car_repair_shop.dtos.serviceOrderDTO.ServiceOrderRequestDTO;
import com.car_repair_shop.dtos.serviceOrderDTO.ServiceOrderResponseDTO;
import com.car_repair_shop.service.ServiceOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/service_orders")
public class ServiceOrderController {

    @Autowired
    private ServiceOrderService serviceOrderService;

    @PostMapping
    public ResponseEntity<ServiceOrderResponseDTO> createServiceOrder(@RequestBody ServiceOrderRequestDTO serviceOrderRequestDTO){
        ServiceOrder serviceOrder = this.serviceOrderService.createServiceOrder(serviceOrderRequestDTO);
        ServiceOrderResponseDTO serviceOrderResponse = ServiceOrderDTOMapper.toDTO(serviceOrder);
        return ResponseEntity.ok(serviceOrderResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceOrderResponseDTO> findOrderById(@PathVariable Long id){
        ServiceOrder serviceOrder = this.serviceOrderService.FindOrderById(id);
        ServiceOrderResponseDTO serviceOrderResponse = ServiceOrderDTOMapper.toDTO(serviceOrder);
        return ResponseEntity.ok(serviceOrderResponse);
    }

    @GetMapping
    public ResponseEntity<List<ServiceOrderResponseDTO>> FindAllOrders(){
        List<ServiceOrderResponseDTO> orders = this.serviceOrderService.FindAllOrders();
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id){
        this.serviceOrderService.deleteOrderById(id);
    }


}
