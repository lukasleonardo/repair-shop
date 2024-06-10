package com.car_repair_shop.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException()  {
        super("Erro interno de Servidor");
    }

    public BadRequestException(String message)  {
        super(message);
    }
}
