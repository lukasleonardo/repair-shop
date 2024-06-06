package com.car_repair_shop.dtos;

import com.car_repair_shop.domain.car.Car;
import com.car_repair_shop.domain.owner.Owner;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;
import java.util.List;

public record ServiceOrderDTO(String description, Timestamp initialDate, List<MultipartFile> prevImages,
                              Long car_id, Long owner_id) {

}
