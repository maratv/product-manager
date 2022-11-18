package productmanager.service;

import org.springframework.stereotype.Service;
import productmanager.model.Product;

import java.util.List;

@Service
public interface ProductService {

    Product save(Product product);

    List<Product> getAllProducts();
}
