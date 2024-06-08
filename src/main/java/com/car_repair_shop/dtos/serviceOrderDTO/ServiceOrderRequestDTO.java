package com.car_repair_shop.dtos.serviceOrderDTO;
import java.sql.Timestamp;
import java.util.List;

public record ServiceOrderRequestDTO(String description, Timestamp initialDate, List<String> prevImages,
                                     Long car_id, Long owner_id) {
    @Override
    public String description() {
        return description;
    }

    @Override
    public Timestamp initialDate() {
        return initialDate;
    }

    @Override
    public List<String> prevImages() {
        return prevImages;
    }

    @Override
    public Long car_id() {
        return car_id;
    }

    @Override
    public Long owner_id() {
        return owner_id;
    }
}
