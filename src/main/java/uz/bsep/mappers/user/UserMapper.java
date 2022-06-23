package uz.bsep.mappers.user;


import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import uz.bsep.dtos.user.UserCreateDto;
import uz.bsep.dtos.user.UserDto;
import uz.bsep.dtos.user.UserUpdateDto;
import uz.bsep.entities.user.User;
import uz.bsep.mappers.base.AbstractMapper;

@Component
@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractMapper<User, UserDto, UserCreateDto, UserUpdateDto> {
}
