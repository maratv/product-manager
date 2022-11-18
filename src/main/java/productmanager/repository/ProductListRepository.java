package productmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import productmanager.model.ProductList;

import java.util.Optional;

public interface ProductListRepository extends MongoRepository<ProductList, Long> {
    Optional<ProductList> findByName(String name);
    Boolean existsByName(String name);

}
