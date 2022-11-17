package productmanager.service;

import org.springframework.stereotype.Service;
import productmanager.model.Product;

@Service
public interface ProductService {

    Product save(Product product);



}
