package productmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Setter
@Document("product_lists")
public class ProductList {

    @Transient
    public static final String SEQUENCE_NAME = "product_list_sequence";

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(hidden = true)
    @Id
    private Long id;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(hidden = true)
    @DBRef
    private List<Product> products = new ArrayList<>();
    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(hidden = true)
    private Integer kCalSum;


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

}

