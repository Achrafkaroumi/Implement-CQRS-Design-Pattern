package karoumi.achraf.productmicroservices.command.api.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCommandRequest {
    private String name;
    private String description;
    private double price;
    private String category;
    private Integer quantity;
}
