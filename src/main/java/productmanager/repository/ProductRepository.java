package productmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import productmanager.model.Product;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, Long> {

    Optional<Product> findByName(String name);

    Boolean existsByName(String name);
}
