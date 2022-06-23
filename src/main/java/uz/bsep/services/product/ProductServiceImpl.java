package uz.bsep.services.product;
import org.springframework.stereotype.Service;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.dtos.product.ProductUpdateDto;
import uz.bsep.mappers.product.ProductMapper;
import uz.bsep.repositories.product.ProductRepository;
import uz.bsep.services.base.AbstractService;
import uz.bsep.validators.base.BaseGenericValidator;

import java.util.List;
@Service
public class ProductServiceImpl extends AbstractService<ProductRepository, ProductMapper, BaseGenericValidator> implements ProductService{


    protected ProductServiceImpl(ProductMapper mapper, BaseGenericValidator validator, ProductRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(ProductCreateDto dto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(ProductUpdateDto dto) {

    }

    @Override
    public ProductDto get(String id) {
        return null;
    }

    @Override
    public List<ProductDto> getAll(GenericCriteria criteria) {
        return null;
    }
}
