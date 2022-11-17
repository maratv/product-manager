package productmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import productmanager.model.ProductList;

public interface ProductListRepository extends MongoRepository<ProductList, Long> {
}
