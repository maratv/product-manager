package productmanager.service;

import org.springframework.stereotype.Service;
import productmanager.exceptions.ItemAlreadyExistException;
import productmanager.model.Product;
import productmanager.repository.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final SequenceGeneratorService sGS;


    public ProductServiceImpl(ProductRepository productRepository, SequenceGeneratorService sGS) {
        this.productRepository = productRepository;
        this.sGS = sGS;
    }

    @Override
    public Product save(Product product) {
        if (!productRepository.existsByName(product.getName())) {
            product.setId(sGS.generateSequence(Product.SEQUENCE_NAME));
            return productRepository.save(product);
        } else throw new ItemAlreadyExistException(product.getName());
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
