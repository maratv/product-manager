package productmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@Document("product_lists")
public class ProductList {

    @Transient
    public static final String SEQUENCE_NAME = "product_list_sequence";

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Id
    private Long id;
    private String name;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @DBRef
    private List<Product> products = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer kCalSum;

    public ProductList(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }


    public Integer getkCalSum() {
        return IntStream.of(products.stream().mapToInt(Product::getKCal).toArray()).sum();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

