package uz.bsep.services.product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.dtos.product.ProductUpdateDto;
import uz.bsep.entities.product.Product;
import uz.bsep.mappers.product.ProductMapper;
import uz.bsep.repositories.product.ProductRepository;
import uz.bsep.services.base.AbstractService;
import uz.bsep.validators.base.BaseGenericValidator;

import java.util.List;


@Service
public class ProductServiceImpl extends AbstractService<ProductRepository, ProductMapper, BaseGenericValidator> implements ProductService{


    @Autowired
    ObjectMapper objectMapper;

    protected ProductServiceImpl(ProductMapper mapper, BaseGenericValidator validator, ProductRepository repository) {
        super(mapper, validator, repository);
    }

    @Override
    public String create(ProductCreateDto dto) {
        Product product = mapper.fromCreateDto(dto);
        repository.save(product);
        return product.getId();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void update(ProductUpdateDto dto) {
        mapper.fromUpdateDto(dto);
    }

    @Override
    public ProductDto get(String id, String lang) {
        String object = repository.getProductById(id, lang);
        try {
            objectMapper.readValue(object, ProductDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ProductDto> getAll(GenericCriteria criteria, String lang) {
        return null;
    }
}
