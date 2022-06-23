package uz.bsep.entities.company;

import lombok.*;
import lombok.experimental.FieldDefaults;
import uz.bsep.entities.base.Auditable;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "socialNetworks")
public class SocialNetwork extends Auditable {
    String mane;

    String logoUrl;

    String link;
}
