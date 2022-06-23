package uz.bsep.mappers.base;


import uz.bsep.dtos.base.BaseGenericDto;
import uz.bsep.dtos.base.GenericDto;
import uz.bsep.entities.base.BaseGenericEntity;
/**
 * param E -> Entity
 * param D -> DTO
 * param CD -> Create DTO
 * param UD -> Update DTO
 */
import java.util.List;

public interface AbstractMapper<
        E extends BaseGenericEntity,
        D extends GenericDto,
        CD extends BaseGenericDto,
        UP extends GenericDto
        > extends BaseGenericMapper {
    D toDto(E entity);

    List<D> toDto(List<E> entities);

    E fromCreateDto(CD createDto);

    E fromUpdateDto(UP updateDto);
}
