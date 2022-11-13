package uz.bsep.dtos.type;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.bsep.dtos.base.GenericDto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TypeDto extends GenericDto {

    @NotEmpty(message = "name uz cannot be empty")
    String nameUz;
    @NotBlank(message = "name ru cannot be blank")
    String nameRu;
    @NotBlank(message = "name eng cannot be blank")
    String nameEn;
}
