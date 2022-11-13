package uz.bsep.dtos.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import uz.bsep.dtos.base.GenericDto;

import java.util.List;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto extends GenericDto {

    String name;
    String description;
    Double price;
    List<String> photos;
    List<ParameterDto> parameters;

    public ProductDto(String name, String description, Double price, List<String> photos, List<ParameterDto> parameters) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.photos = photos;
        this.parameters = parameters;
    }

    public ProductDto(String id, String name, String description, Double price, List<String> photos, List<ParameterDto> parameters) {
        super(id);
        this.name = name;
        this.description = description;
        this.price = price;
        this.photos = photos;
        this.parameters = parameters;
    }

    public ProductDto(){
    }
}
