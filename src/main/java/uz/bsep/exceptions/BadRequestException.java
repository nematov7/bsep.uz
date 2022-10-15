package uz.bsep.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.bsep.exceptions.base.AbstractException;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends AbstractException {

    public BadRequestException(String message) {
        super(message);
    }
}
