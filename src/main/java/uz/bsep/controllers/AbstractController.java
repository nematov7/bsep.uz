package uz.bsep.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import uz.bsep.dtos.exception.ExceptionDto;
import uz.bsep.services.base.BaseGenericService;

public abstract class AbstractController<S extends BaseGenericService> {

    protected final S service;
    public static final String API = "/api";
    public static final String VERSION = "/v1";
    public static final String PATH = API + VERSION;


    protected AbstractController(S service) {
        this.service = service;
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDto> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        StringBuilder errors = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String errorMessage = error.getDefaultMessage();
            errors.append(errorMessage).append("\n");
        });
        errors.delete(errors.length()-1, errors.length());
        return new ResponseEntity<>(new ExceptionDto((request + "").substring(23, request.toString().indexOf(";client")), 400, errors.toString()), HttpStatus.BAD_REQUEST);
    }
}
