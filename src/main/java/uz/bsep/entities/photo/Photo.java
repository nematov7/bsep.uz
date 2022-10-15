package uz.bsep.entities.photo;


import uz.bsep.entities.base.Auditable;
import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.bsep.entities.base.BaseGenericEntity;
import uz.bsep.entities.product.Product;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "photos")
public class Photo implements BaseGenericEntity {
    @Id
    String path;
    @ManyToOne
    Product product;
}
