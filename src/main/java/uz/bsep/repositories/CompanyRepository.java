package uz.bsep.repositories;

import org.springframework.data.jpa.repository.Query;
import uz.bsep.entities.company.Company;
import uz.bsep.repositories.base.AbstractRepository;

public interface CompanyRepository extends AbstractRepository<Company, String> {
    @Query(value = "select c.name, cast((c.description_translate->:lang)as text), c.phone_numbers,c.email ,c.address,c.longitude,c.latitude, c.photos from companies c", nativeQuery = true)
    String getCompanyBYId( String lang);


}
