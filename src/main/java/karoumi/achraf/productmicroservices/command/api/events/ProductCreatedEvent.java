package karoumi.achraf.productmicroservices.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class ProductCreatedEvent {
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private Integer quantity;
}
