package uz.bsep.mappers.type;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.bsep.dtos.type.TypeDto;
import uz.bsep.entities.product.Type;
import uz.bsep.mappers.base.AbstractMapper;
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TypeMapper extends AbstractMapper<Type, TypeDto,TypeDto,TypeDto> {
    @Override
    @Mappings({
            @Mapping(target = "nameTranslate.uz", source = "dto.nameUz"),
            @Mapping(target = "nameTranslate.ru", source = "dto.nameRu"),
            @Mapping(target = "nameTranslate.en", source = "dto.nameEn")
    })
    Type fromCreateDto(TypeDto dto);
}
