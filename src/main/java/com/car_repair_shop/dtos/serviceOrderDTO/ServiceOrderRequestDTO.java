package com.car_repair_shop.dtos.serviceOrderDTO;
import java.sql.Timestamp;
import java.util.List;

public record ServiceOrderRequestDTO(String description, Timestamp initialDate, List<String> prevImages,
                                     Long car_id, Long owner_id) {

}
