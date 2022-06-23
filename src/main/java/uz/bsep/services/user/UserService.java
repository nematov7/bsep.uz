package uz.bsep.services.user;


import uz.bsep.criteria.base.BaseGenericCriteria;
import uz.bsep.dtos.user.UserCreateDto;
import uz.bsep.dtos.user.UserDto;
import uz.bsep.dtos.user.UserUpdateDto;
import uz.bsep.services.base.GenericCrudService;

public interface UserService extends GenericCrudService<
        UserDto,
        UserCreateDto,
        UserUpdateDto,
        String,
        BaseGenericCriteria
        > {

}
