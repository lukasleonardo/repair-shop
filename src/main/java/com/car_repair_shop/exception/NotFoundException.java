package com.car_repair_shop.exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("URL não encontrada");
    }

    public NotFoundException(String message) {
        super(message);
    }


}
