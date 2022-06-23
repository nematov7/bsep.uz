package uz.bsep.entities.company;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import uz.bsep.entities.TranslateJson;
import uz.bsep.entities.base.Auditable;
import uz.bsep.entities.photo.Photo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "companies")
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})

public class Company extends Auditable {
    String name;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    TranslateJson descriptionTranslate;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    List<String> phoneNumbers=new ArrayList<>();

    String email;

    String address;

    Double longitude;

    Double latitude;
    @OneToMany
    List<Photo> photos = new ArrayList<>();

}
