package uz.bsep.services.user;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.bsep.criteria.base.BaseGenericCriteria;
import uz.bsep.dtos.user.UserCreateDto;
import uz.bsep.dtos.user.UserDto;
import uz.bsep.dtos.user.UserUpdateDto;
import uz.bsep.exceptions.ResourceNotFoundException;
import uz.bsep.mappers.user.UserMapper;
import uz.bsep.repositories.user.UserRepository;
import uz.bsep.services.base.AbstractService;
import uz.bsep.validators.user.UserValidator;

import java.util.List;

@Service
public class UserServiceImp extends AbstractService<
        UserRepository,
        UserMapper,
        UserValidator
        > implements UserService {

    protected UserServiceImp(UserMapper mapper, UserValidator validator, UserRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(UserCreateDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(UserUpdateDto dto) {

    }

    @Override
    public UserDto get(String id, String lang) {
        return null;
    }

    @Override
    public List<UserDto> getAll(BaseGenericCriteria criteria, String lang) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("user not found"));
    }
}
