package uz.bsep.criteria.base;

import lombok.*;
import org.springdoc.api.annotations.ParameterObject;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
@ParameterObject
public class GenericCriteria implements BaseGenericCriteria, Serializable {

    public Integer page = 1;

    public Integer size = 9;

    public String typeId;

}