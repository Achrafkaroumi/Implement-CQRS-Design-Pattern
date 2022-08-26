package karoumi.achraf.productmicroservices.common.api.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductQueryResponse {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private Integer quantity;
}
