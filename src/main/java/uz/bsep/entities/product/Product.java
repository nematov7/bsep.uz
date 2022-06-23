package uz.bsep.entities.product;

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

@Entity(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Product extends Auditable {

    @Column(nullable = false)
    String name;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    TranslateJson nameTranslate;

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    TranslateJson descriptionTranslate;

    @OneToMany
    List<Photo> photosUrls=new ArrayList<>();

    @OneToMany
    List<Parameter> parameters =new ArrayList<>();

    Double price;

}
