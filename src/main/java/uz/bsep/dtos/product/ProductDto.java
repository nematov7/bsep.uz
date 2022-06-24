package uz.bsep.dtos.product;

import uz.bsep.dtos.base.GenericDto;
import uz.bsep.entities.photo.Photo;
import uz.bsep.entities.product.Parameter;

import java.util.List;

public class ProductDto extends GenericDto {

    String name;
    String description;
    String price;
    List<String> photos;
    List<ParameterDto> parameters;

    public ProductDto(String name, String description, String price, List<String> photos, List<ParameterDto> parameters) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.photos = photos;
        this.parameters = parameters;
    }

    public ProductDto(String id, String name, String description, String price, List<String> photos, List<ParameterDto> parameters) {
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
