package uz.bsep.entities.product;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import uz.bsep.entities.TranslateJson;
import uz.bsep.entities.base.BaseGenericEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
@Entity(name = "types")
public class Type implements BaseGenericEntity {

    @Id
    String id = UUID.randomUUID().toString();

    @org.hibernate.annotations.Type(type = "json")
    @Column(columnDefinition = "jsonb")
    TranslateJson nameTranslate;

    public Type(){
        this.id = UUID.randomUUID().toString();
    }

    public Type(TranslateJson nameTranslate) {
        this.id = UUID.randomUUID().toString();
        this.nameTranslate = nameTranslate;
    }
}
