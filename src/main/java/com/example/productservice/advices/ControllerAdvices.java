package com.example.productservice.advices;

import com.example.productservice.exceptions.NotFoundException;
import com.example.productservice.viewModels.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvices {
    @ExceptionHandler(NotFoundException.class)
    private ResponseEntity<ExceptionDto> handleNoteException(NotFoundException ne) {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, ne.getMessage()), HttpStatus.NOT_FOUND);
    }
}
