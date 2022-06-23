package uz.bsep.services.base;



import uz.bsep.criteria.base.BaseGenericCriteria;
import uz.bsep.dtos.base.BaseGenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericService<
        D extends BaseGenericDto,
        K extends Serializable,
        C extends BaseGenericCriteria
        > extends BaseGenericService {

    D get(K id);

    List<D> getAll(C criteria);

}
