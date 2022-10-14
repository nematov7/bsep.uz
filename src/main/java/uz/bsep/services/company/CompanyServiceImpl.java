package uz.bsep.services.company;

import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.company.CompanyCreateDto;
import uz.bsep.dtos.company.CompanyDto;
import uz.bsep.dtos.company.CompanyUpdateDto;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {
    @Override
    public String create(CompanyCreateDto dto) {
        return null;
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
