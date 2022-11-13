package uz.bsep.repositories.type;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bsep.entities.product.Type;
import uz.bsep.repositories.base.AbstractRepository;

@Repository
public interface TypeRepository extends AbstractRepository<Type, String> {
    @Query(value = """
            select
                   cast (json_agg(
                       json_build_object(
                           'id', t.id,
                           'name', t.name_translate -> :lang
                           )
                       ) as text)
            from types t
                        """, nativeQuery = true)
    String getAll(String lang);
}
