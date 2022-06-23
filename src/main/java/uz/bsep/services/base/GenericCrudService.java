package uz.bsep.services.base;


import uz.bsep.criteria.base.BaseGenericCriteria;
import uz.bsep.dtos.base.BaseGenericDto;
import uz.bsep.dtos.base.GenericDto;

import java.io.Serializable;

/**
 *
 * @param <D> ->
 * @param <CD> ->
 * @param <UD> ->
 * @param <K> ->
 * @param <C> ->
 */

public interface GenericCrudService<
        D extends GenericDto,
        CD extends BaseGenericDto,
        UD extends GenericDto,
        K extends Serializable,
        C extends BaseGenericCriteria
        > extends GenericService<D, K, C> {
    K create(CD dto);

    void delete(K id);

    void update(UD dto);

}
