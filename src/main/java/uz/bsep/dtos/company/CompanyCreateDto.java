package uz.bsep.dtos.company;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.bsep.dtos.base.BaseGenericDto;
import uz.bsep.dtos.base.GenericDto;
import uz.bsep.entities.photo.Photo;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CompanyCreateDto implements BaseGenericDto {
    String name;

    String descriptionUz;

    String descriptionEn;

    String descriptionRu;

    List<String> phoneNumbers ;

    String email;

    String address;

    Double longitude;

    Double latitude;

    List<String> photos;

}
