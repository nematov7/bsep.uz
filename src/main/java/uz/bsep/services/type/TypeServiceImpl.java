package uz.bsep.services.type;

import com.google.gson.Gson;
import org.springframework.stereotype.Service;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.type.TypeCreateDto;
import uz.bsep.dtos.type.TypeDto;
import uz.bsep.entities.product.Type;
import uz.bsep.mappers.type.TypeMapper;
import uz.bsep.repositories.type.TypeRepository;
import uz.bsep.services.base.AbstractService;
import uz.bsep.validators.base.BaseGenericValidator;

import java.util.List;
import java.util.UUID;

@Service
public class TypeServiceImpl extends AbstractService<TypeRepository, TypeMapper, BaseGenericValidator> implements TypeService  {
    protected TypeServiceImpl(TypeMapper mapper, BaseGenericValidator validator, TypeRepository repository, Gson gson) {
        super(mapper, validator, repository);
        this.gson = gson;
    }
    private final Gson gson;

    @Override
    public String create(TypeDto dto) {
        Type type = mapper.fromCreateDto(dto);
        type.setId(UUID.randomUUID().toString());
        repository.save(type);
        return type.getId();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

    @Override
    public void update(TypeDto dto) {

    }

    @Override
    public TypeDto get(String id, String lang) {
        return null;
    }

    @Override
    public List<TypeDto> getAll(GenericCriteria criteria, String lang) {
        return null;
    }

    public List<TypeCreateDto> getAlll(String lang) {
      String value = repository.getAll(lang);
        List<TypeCreateDto> list = gson.fromJson(value, List.class);
        return list;
    }
}
