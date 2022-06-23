package uz.bsep.entities.product;

import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.*;
import lombok.experimental.PackagePrivate;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import uz.bsep.entities.TranslateJson;
import uz.bsep.entities.base.Auditable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "parameters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@PackagePrivate
@TypeDefs({
        @TypeDef(name = "string-array", typeClass = StringArrayType.class),
        @TypeDef(name = "int-array", typeClass = IntArrayType.class),
        @TypeDef(name = "json", typeClass = JsonType.class)
})
public class Parameter extends Auditable {

    @Type(type = "json")
    @Column(columnDefinition = "jsonb")
    TranslateJson nameTranslateJson;

    String value;
}
