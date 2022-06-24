package uz.bsep.repositories.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bsep.entities.product.Product;
import uz.bsep.repositories.base.AbstractRepository;
@Repository
public interface ProductRepository extends AbstractRepository<Product,String> {

    @Query(value = """
        select
               cast(json_build_object('id', js.id, 'price', js.price, 'name', js.name, 'description' ,js.description, 'photos', js.photos, 'parameters', js.parametrs ) as text) as object
        from (select pr.id,
                     pr.price,
                     pr.name_translate -> :lang as "name",
                     pr.description_translate -> :lang  as "description",
                     json_agg(photos)                                                                      as "photos",
                     json_agg(json_build_object('name', p.name_translate_json -> :lang, 'value', p.value)) as "parametrs"
              from products as pr
                       join photos on pr.id = photos.product_id
                       join parameters p on pr.id = p.product_id
                       where pr.id = :id and pr.is_deleted = 0
              group by pr.id, pr.price, pr.id, pr.name_translate -> :lang, pr.description_translate -> :lang) js
        """, nativeQuery = true)
    String getProductById(String id, String lang);
}
