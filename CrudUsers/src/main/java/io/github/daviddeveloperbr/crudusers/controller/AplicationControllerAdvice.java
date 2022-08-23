package io.github.daviddeveloperbr.crudusers.controller;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.*;

@RestControllerAdvice
public class AplicationControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(BAD_REQUEST)
    public ApiErrors handleMethodNotValidException(MethodArgumentNotValidException ex){

        List<String> errors = ex.getBindingResult().getAllErrors().stream().map(erro->
                erro.getDefaultMessage()).collect(Collectors.toList());

        return new ApiErrors(errors);
    }


}