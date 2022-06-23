package uz.bsep.repositories.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import uz.bsep.entities.base.BaseGenericEntity;

import java.io.Serializable;

@NoRepositoryBean
public interface AbstractRepository<
        E extends BaseGenericEntity,
        K extends Serializable
        > extends BaseGenericRepository, JpaRepository<E,K> {

}
