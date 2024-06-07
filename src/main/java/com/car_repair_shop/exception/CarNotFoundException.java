package com.car_repair_shop.exception;

public class CarNotFoundException extends RuntimeException {

    public CarNotFoundException() {
        super("Carro não encontrado");
    }

    public CarNotFoundException(String message) {
        super(message);
    }

    public CarNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CarNotFoundException(Throwable cause) {
        super(cause);
    }
}
