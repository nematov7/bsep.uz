package uz.bsep.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import uz.bsep.dtos.company.CompanyCreateDto;
import uz.bsep.dtos.company.CompanyDto;
import uz.bsep.dtos.company.CompanyUpdateDto;
import uz.bsep.entities.company.Company;
import uz.bsep.mappers.base.AbstractMapper;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CompanyMapper extends AbstractMapper<Company, CompanyDto, CompanyCreateDto, CompanyUpdateDto> {

}
