package productmanager.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import productmanager.config.SwaggerConfig;
import productmanager.model.ProductList;
import productmanager.service.ProductListService;

import java.util.List;

@RestController
@RequestMapping("/lists")
@Api(tags = {SwaggerConfig.PRODUCT_LIST_TAG})
public class ProductListController {

    private final ProductListService productListService;

    public ProductListController(ProductListService productListService) {
        this.productListService = productListService;
    }

    @PostMapping
    @ApiOperation("Save new Product list")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductList save(ProductList productList) {
        return productListService.save(productList);
    }

    @GetMapping
    @ApiOperation("Get all Product lists")
    @ResponseStatus(code = HttpStatus.CREATED)
    public List<ProductList> getAll() {
        return productListService.getAllProductListsService();
    }

    @PostMapping("/{list}")
    @ApiOperation("Add Product to List")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductList addProductToList(String productName, @PathVariable("list") String listName) {
        return productListService.addProductToListService(productName, listName);
    }
}
