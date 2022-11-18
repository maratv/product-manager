package productmanager.service;

import org.springframework.stereotype.Service;
import productmanager.exceptions.ItemAlreadyExistException;
import productmanager.exceptions.ItemNotFoundException;
import productmanager.model.Product;
import productmanager.model.ProductList;
import productmanager.repository.ProductListRepository;
import productmanager.repository.ProductRepository;

import java.util.List;

@Service
public class ProductListServiceImpl implements ProductListService {

    private final ProductRepository productRepository;
    private final ProductListRepository productListRepository;
    private final SequenceGeneratorService sGS;


    public ProductListServiceImpl(ProductRepository productRepository,
                                  ProductListRepository productListRepository,
                                  SequenceGeneratorService sGS) {
        this.productRepository = productRepository;
        this.productListRepository = productListRepository;
        this.sGS = sGS;
    }

    @Override
    public ProductList save(ProductList productList) {
        if (!productListRepository.existsByName(productList.getName())) {
            productList.setId(sGS.generateSequence(ProductList.SEQUENCE_NAME));
            return productListRepository.save(productList);
        } else throw new ItemAlreadyExistException(productList.getName());
    }

    @Override
    public List<ProductList> getAllProductListsService() {
        return productListRepository.findAll();
    }

    @Override
    public ProductList addProductToListService(String productName, String listName) {
        productRepository.findByName(productName)
                .orElseThrow(() -> new ItemNotFoundException(productName));
        productListRepository.findByName(listName)
                .orElseThrow(() -> new ItemNotFoundException(productName));
        Product product = productRepository.findByName(productName).get();
        ProductList productList = productListRepository.findByName(listName).get();

        List<Product> products = productList.getProducts();
        products.add(product);
        productList.setProducts(null);
        productList.setProducts(products);
        return productListRepository.save(productList);
    }
}
