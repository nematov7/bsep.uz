package uz.bsep.exceptions.base;

public class AbstractException extends RuntimeException implements BaseGenericException{

    public AbstractException(String message) {
        super(message);
    }
}
