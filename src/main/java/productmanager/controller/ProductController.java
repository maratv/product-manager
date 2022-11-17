package productmanager.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import productmanager.model.Product;
import productmanager.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(Product product) {


        return productService.save(product);
    }



}
