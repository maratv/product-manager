package productmanager.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "products")

public class Product {


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    private String id;
    private String name;
//    private String description;
//    private Integer kCal;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
