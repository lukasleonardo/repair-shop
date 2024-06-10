package com.car_repair_shop.dtoMappers;

import com.car_repair_shop.domain.service_order.ServiceOrder;
import com.car_repair_shop.domain.user.User;
import com.car_repair_shop.dtos.serviceOrderDTO.ServiceOrderResponseDTO;


public class ServiceOrderDTOMapper {
    public static ServiceOrderResponseDTO toDTO(ServiceOrder serviceOrder) {
        return new ServiceOrderResponseDTO(
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
