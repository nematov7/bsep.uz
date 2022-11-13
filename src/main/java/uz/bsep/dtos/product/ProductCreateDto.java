package uz.bsep.dtos.product;

import lombok.experimental.FieldDefaults;
import uz.bsep.dtos.base.BaseGenericDto;
import lombok.*;
import uz.bsep.entities.product.Parameter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductCreateDto implements BaseGenericDto {
    @NotNull(message = "name uz cannot be null") @NotEmpty(message = "name uz cannot be empty") @NotBlank(message = "name ")
    String nameUz;
    String nameEn;
    String nameRu;
    String descriptionUz;
    String descriptionEn;
    String descriptionRu;
    Double price;
    List<Parameter> parameters;
    List<String> photos;
    String typeId;
}
