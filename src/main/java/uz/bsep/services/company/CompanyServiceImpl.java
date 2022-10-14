package uz.bsep.services.company;

import org.springframework.stereotype.Service;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.company.CompanyCreateDto;
import uz.bsep.dtos.company.CompanyDto;
import uz.bsep.dtos.company.CompanyUpdateDto;
import uz.bsep.entities.TranslateJson;
import uz.bsep.entities.company.Company;
import uz.bsep.mappers.CompanyMapper;
import uz.bsep.repositories.CompanyRepository;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper mapper;
    private final CompanyRepository repository;

    public CompanyServiceImpl(CompanyMapper mapper, CompanyRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public String create(CompanyCreateDto dto) {
        TranslateJson translateJson = new TranslateJson(dto.getDescriptionUz(), dto.getDescriptionRu(), dto.getDescriptionEn());
        Company company = mapper.fromCreateDto(dto);
        company.setDescriptionTranslate(translateJson);
        Company save = repository.save(company);
        return "";
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(CompanyUpdateDto dto) {

    }

    @Override
    public CompanyDto get(String id, String lang) {
        return null;
    }

    @Override
    public List<CompanyDto> getAll(GenericCriteria criteria, String lang) {
        return null;
    }
}

