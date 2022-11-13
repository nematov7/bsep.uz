package uz.bsep.entities.product;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import uz.bsep.entities.TranslateJson;
import uz.bsep.entities.base.Auditable;

import javax.persistence.*;
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

    @org.hibernate.annotations.Type(type = "json")
    @Column(columnDefinition = "jsonb")
    TranslateJson nameTranslate;

    @org.hibernate.annotations.Type(type = "json")
    @Column(columnDefinition = "jsonb")
    TranslateJson descriptionTranslate;


    @org.hibernate.annotations.Type(type = "json")
    @Column(columnDefinition = "jsonb")
     List<String> photos = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    List<Parameter> parameters = new ArrayList<>();

    @Column(nullable = false)
    Double price;

    @ManyToOne
    Type type;

    public void addParam(Parameter param) {
        parameters.add(param);
    }
}
