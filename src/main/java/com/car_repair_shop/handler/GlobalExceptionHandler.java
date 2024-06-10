package com.car_repair_shop.handler;

import com.car_repair_shop.dtos.exceptionDTO.ExceptionDTO;
import com.car_repair_shop.exception.BadRequestException;
import com.car_repair_shop.exception.NotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeneralException(Exception e) {
        ExceptionDTO err = new ExceptionDTO("Erro interno do Servidor",HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(err,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> handleDataException(DataIntegrityViolationException e) {
        ExceptionDTO err = new ExceptionDTO("Login já Cadastrado!",HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> handleBadRequest(BadRequestException e) {
        ExceptionDTO errorResponse = new ExceptionDTO(
                e.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleCarNotFoundException(NotFoundException e) {
        ExceptionDTO errorResponse = new ExceptionDTO(
                e.getMessage(),
                HttpStatus.NOT_FOUND.value()
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }


}