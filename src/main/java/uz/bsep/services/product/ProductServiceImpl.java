package uz.bsep.services.product;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.dtos.product.ProductUpdateDto;
import uz.bsep.entities.product.Parameter;
import uz.bsep.entities.product.Product;
import uz.bsep.entities.product.Type;
import uz.bsep.exceptions.ResourceNotFoundException;
import uz.bsep.mappers.product.ProductMapper;
import uz.bsep.projections.SingleProduct;
import uz.bsep.repositories.product.ProductRepository;
import uz.bsep.repositories.type.TypeRepository;
import uz.bsep.services.base.AbstractService;
import uz.bsep.validators.base.BaseGenericValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl extends AbstractService<ProductRepository, ProductMapper, BaseGenericValidator> implements ProductService {


    private final ObjectMapper objectMapper;
    private final TypeRepository typeRepository;


    protected ProductServiceImpl(ProductMapper mapper, BaseGenericValidator validator, ProductRepository repository, ObjectMapper objectMapper, TypeRepository typeRepository) {
        super(mapper, validator, repository);
        this.objectMapper = objectMapper;
        this.typeRepository = typeRepository;
    }

    @Override
    public String create(ProductCreateDto dto) {

        Product product = mapper.fromCreateDto(dto);
        Type type = typeRepository.findById(dto.getTypeId()).orElseThrow(() -> new ResourceNotFoundException("type not found"));
        product.setType(type);
        product.getParameters().forEach(parameter -> parameter.setProduct(product));
        repository.save(product);
        return product.getId();
    }

    @Override
    public void delete(String id) {
        try {
            repository.deleteById(id);

        } catch (Exception e) {

        }
    }

    @Override
    public void update(ProductUpdateDto dto) {
        mapper.fromUpdateDto(dto);
    }

    @Override
    public ProductDto get(String id, String lang) {
        String object = repository.getProductById(id, lang);

        try {
            Gson gson = new Gson();
            return gson.fromJson(object, ProductDto.class);
//          return   objectMapper.readValue(object, ProductDto.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<ProductDto> getAll(GenericCriteria criteria, String lang) {
return null; // TODO: 04.11.2022  
    }

    public List<SingleProduct> getAllTypeIdOne(String lang) {
        return repository.getSingleProduct(lang);
    }

    public List<SingleProduct> getSingleProduct(String lang){
        return repository.getSingleProduct(lang);
    }

    public List<SingleProduct> getAllByTypeId(String typeId, String lang) {
        return repository.getAllByTypeId(lang, typeId);
    }
}
