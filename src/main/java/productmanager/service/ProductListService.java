package productmanager.service;

import org.springframework.stereotype.Service;
import productmanager.model.ProductList;

import java.util.List;

@Service
public interface ProductListService {

    ProductList save(ProductList productList);

    List<ProductList> getAllProductListsService();

    ProductList addProductToListService(String productName, String listName);

}
