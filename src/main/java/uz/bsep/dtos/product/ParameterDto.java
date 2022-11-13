package uz.bsep.dtos.product;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.bsep.dtos.base.GenericDto;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class    ParameterDto extends GenericDto {

    String name;

    String value;
}
