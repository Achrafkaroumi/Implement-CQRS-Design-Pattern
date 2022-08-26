package karoumi.achraf.productmicroservices.command.api.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
@AllArgsConstructor @NoArgsConstructor
@Builder
public class CreateProductCommand {
    @TargetAggregateIdentifier
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private Integer quantity;
}
