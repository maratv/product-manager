package productmanager.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "products")
public class Product {

    @Transient
    public static final String SEQUENCE_NAME = "product_sequence";

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ApiModelProperty(hidden = true)
    private long id;
    private String name;
    private String description;
    private Integer kCal;
}
