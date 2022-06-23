package uz.bsep.validators.user;


import org.springframework.stereotype.Component;
import uz.bsep.dtos.user.UserCreateDto;
import uz.bsep.dtos.user.UserUpdateDto;
import uz.bsep.validators.base.AbstractValidator;

import javax.xml.bind.ValidationException;

@Component
public class UserValidator extends AbstractValidator<UserCreateDto, UserUpdateDto, String> {
    @Override
    public void validateKey(String id) throws ValidationException {

    }

    @Override
    public void validOnCreate(UserCreateDto userCreateDto) throws ValidationException {

    }

    @Override
    public void validOnUpdate(UserUpdateDto cd) throws ValidationException {

    }
}
