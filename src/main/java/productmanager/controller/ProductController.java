package productmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import productmanager.config.SwaggerConfig;
import productmanager.model.Product;
import productmanager.service.ProductService;

import java.util.List;
@RestController
@RequestMapping("/product")
@Api(tags = {SwaggerConfig.PRODUCT_TAG})
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ApiOperation("Save new product")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Product save(Product product) {
        return productService.save(product);
    }

    @GetMapping
    @ApiOperation("Get all products")
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

}
