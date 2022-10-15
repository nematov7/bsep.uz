package uz.bsep.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import uz.bsep.dtos.exception.ExceptionDto;
import uz.bsep.exceptions.BadRequestException;
import uz.bsep.exceptions.ResourceFoundException;
import uz.bsep.exceptions.ResourceNotFoundException;


@ControllerAdvice
public class RestResponseEntityExceptionHandler
  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = BadRequestException.class)
    protected ResponseEntity<ExceptionDto> handlerBadRequestException(BadRequestException exception, WebRequest request){
        return ResponseEntity.badRequest().body(new ExceptionDto((request + "").substring(23, request.toString().indexOf(";client")), 400, exception.getMessage()));
    }

    @ExceptionHandler(value = ResourceFoundException.class)
    protected ResponseEntity<ExceptionDto> handlerResourceFoundException(BadRequestException exception,  WebRequest request){
        return new ResponseEntity<>(new ExceptionDto((request+"").substring(23, request.toString().indexOf(";client")), 302, exception.getMessage()), HttpStatus.FOUND);
    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    protected ResponseEntity<ExceptionDto> handlerResourceNotFoundException(BadRequestException exception,  WebRequest request){
        System.out.println(request);
        return new ResponseEntity<>(new ExceptionDto((request+"").substring(23, request.toString().indexOf(";client")), 404, exception.getMessage()), HttpStatus.NOT_FOUND);
    }

//    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ExceptionDto> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
//        StringBuilder errors = new StringBuilder();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String errorMessage = error.getDefaultMessage();
//            errors.append(errorMessage).append("\n");
//        });
//        errors.delete(errors.length()-2, errors.length());
//        return new ResponseEntity<>(new ExceptionDto((request + "").substring(23, request.toString().indexOf(";client")), 400, errors.toString()), HttpStatus.BAD_REQUEST);
//    }






}