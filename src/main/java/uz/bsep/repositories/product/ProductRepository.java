package uz.bsep.repositories.product;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import uz.bsep.entities.product.Product;
import uz.bsep.projections.SingleProduct;
import uz.bsep.repositories.base.AbstractRepository;

import java.util.List;

@Repository
public interface ProductRepository extends AbstractRepository<Product, String> {

    @Query(value = """
            select
                   cast(json_build_object('id', js.id, 'price', js.price, 'name', js.name, 'description' ,js.description, 'photos', js.photos, 'parameters', js.parametrs ) as text) as object
            from (select pr.id,
                         pr.price,
                         pr.name_translate -> :lang as "name",
                         pr.description_translate -> :lang  as "description",
                         pr.photos                                                                  as "photos",
                         json_agg(json_build_object('name', p.name_translate_json -> :lang, 'value', p.value)) as "parametrs"
                  from products as pr
                           join parameters p on pr.id = p.product_id
                           where pr.id = :id and pr.is_deleted = 1
                  group by pr.id) js
            """, nativeQuery = true)
    String getProductById(String id, String lang);

    @Query(value = """
            select distinct first_value(p.name_translate ->> :lang) over (partition by t.id) "productName",
                            first_value(p.id) over (partition by t.id)                       "productId",
                            first_value(p.photos ->> 1) over (partition by t.id)             "photo",
                            t.id                                                             "typeId",
                            t.name_translate ->> :lang                                       "typeName"
            from types t
                     join products p on t.id = p.type_id
            """, nativeQuery = true)
    List<SingleProduct> getSingleProduct(String lang);


    @Query(value = """
select  * from get_products(i_lang =>:lang , i_page => 1, i_size => 4,i_type_id =>:typeId)
            """,nativeQuery = true)
    List<SingleProduct> getAllByTypeId(String lang, String typeId);
}