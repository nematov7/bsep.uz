package uz.bsep.entities.photo;


import uz.bsep.entities.base.Auditable;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.bsep.entities.product.Product;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "photos")
public class Photo extends Auditable {
    String path;
}
