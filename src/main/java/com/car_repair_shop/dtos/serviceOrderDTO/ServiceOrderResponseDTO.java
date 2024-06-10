package com.car_repair_shop.dtos.serviceOrderDTO;

import com.car_repair_shop.domain.service_order.ServiceOrder;

import java.time.LocalDate;
import java.util.List;

public record ServiceOrderResponseDTO(Long id, String description, LocalDate initialDate, LocalDate finalDate, List<String> prevImages,
                                      List<String> afterImages, Long car_id, Long owner_id) {
    public ServiceOrderResponseDTO(ServiceOrder serviceOrder){
        this(
                serviceOrder.getId(),
                serviceOrder.getDescription(),
                serviceOrder.getInitialDate(),
                serviceOrder.getFinalDate(),
                serviceOrder.getPrevImages(),
                serviceOrder.getAfterImages(),
                serviceOrder.getOwner().getId(),
                serviceOrder.getCar().getId()
                );
    }
}
