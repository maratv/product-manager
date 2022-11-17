package productmanager.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import productmanager.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
