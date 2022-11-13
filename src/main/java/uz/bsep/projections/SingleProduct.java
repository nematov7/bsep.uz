package uz.bsep.projections;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public interface SingleProduct {

    String getProductName();

    String getProductId();

    String getPhoto();

    String getTypeId();

    String getTypeName();
}
