package uz.bsep.services.product;

import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.dtos.product.ProductUpdateDto;
import uz.bsep.services.base.BaseGenericService;
import uz.bsep.services.base.GenericCrudService;

public interface ProductService extends GenericCrudService<ProductDto, ProductCreateDto, ProductUpdateDto, String, GenericCriteria> {
}
