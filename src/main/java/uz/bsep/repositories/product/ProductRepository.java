package uz.bsep.repositories.product;

import org.springframework.stereotype.Repository;
import uz.bsep.entities.product.Product;
import uz.bsep.repositories.base.AbstractRepository;
@Repository
public interface ProductRepository extends AbstractRepository<Product,String> {
}
