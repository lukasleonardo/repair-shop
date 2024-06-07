package com.car_repair_shop.exception;

public class OwnerNotFoundException extends RuntimeException{

    public OwnerNotFoundException() {
        super("Carro não encontrado");
    }

    public OwnerNotFoundException(String message) {
        super(message);
    }

    public OwnerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public OwnerNotFoundException(Throwable cause) {
        super(cause);
    }

}
