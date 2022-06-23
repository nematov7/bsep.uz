package uz.bsep.mappers.product;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.dtos.product.ProductUpdateDto;
import uz.bsep.entities.product.Product;
import uz.bsep.mappers.base.AbstractMapper;


@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ProductMapper extends AbstractMapper<Product, ProductDto, ProductCreateDto, ProductUpdateDto> {

    @Mappings(
            {
                    @Mapping(target = "nameTranslate.uz", source = "dto.nameUz"),
                    @Mapping(target = "nameTranslate.ru", source = "dto.nameRu"),
                    @Mapping(target = "nameTranslate.en", source = "dto.nameEn"),
                    @Mapping(target = "descriptionTranslate.uz", source = "dto.descriptionUz"),
                    @Mapping(target = "descriptionTranslate.ru", source = "dto.descriptionRu"),
                    @Mapping(target = "descriptionTranslate.en", source = "dto.descriptionEn")
            }
    )
    Product fromDto(ProductCreateDto dto);
}
