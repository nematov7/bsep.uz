package uz.bsep.services.base;


import uz.bsep.mappers.base.BaseGenericMapper;
import uz.bsep.repositories.base.BaseGenericRepository;
import uz.bsep.validators.base.BaseGenericValidator;

/**
 *
 * @param <R>
 * @param <M>
 * @param <V>
 */
public abstract class AbstractService<
        R extends BaseGenericRepository,
        M extends BaseGenericMapper,
        V extends BaseGenericValidator
        > implements BaseGenericService {

    protected final M mapper;
    protected final V validator;
    protected final R repository;

    protected AbstractService(M mapper, V validator, R repository) {
        this.mapper = mapper;
        this.validator = validator;
        this.repository = repository;
    }

}
