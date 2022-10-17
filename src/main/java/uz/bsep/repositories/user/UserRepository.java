package uz.bsep.repositories.user;


import org.springframework.stereotype.Repository;
import uz.bsep.entities.user.User;
import uz.bsep.repositories.base.AbstractRepository;

import java.util.Optional;

@Repository
public interface UserRepository extends AbstractRepository<User, String> {

    Optional<User> findByUsername(String username);
}
