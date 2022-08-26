package karoumi.achraf.productmicroservices.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity(name = "tbl_products")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private Integer quantity;
}
