package uz.bsep.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import uz.bsep.exceptions.base.AbstractException;


@ResponseStatus(value = HttpStatus.FOUND)
public class ResourceFoundException extends AbstractException {
    public ResourceFoundException(String message) {
        super(message);
    }
}
