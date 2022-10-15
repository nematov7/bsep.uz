package uz.bsep.services.company;

import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.company.CompanyCreateDto;
import uz.bsep.dtos.company.CompanyDto;
import uz.bsep.dtos.company.CompanyUpdateDto;
import uz.bsep.services.base.GenericCrudService;

public interface CompanyService extends GenericCrudService<CompanyDto, CompanyCreateDto, CompanyUpdateDto,String , GenericCriteria> {
}
