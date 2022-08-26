package karoumi.achraf.productmicroservices.command.api.aggregates;

import karoumi.achraf.productmicroservices.command.api.commands.CreateProductCommand;
import karoumi.achraf.productmicroservices.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;
    private Integer quantity;

    public ProductAggregate() {}

    @CommandHandler
    public ProductAggregate(CreateProductCommand command){
        if(command.getPrice()<=0){throw new IllegalArgumentException("Le prix doit être inférieur du 0");}
        if(command.getQuantity()<=0){throw new IllegalArgumentException("Quantité doit être inférieur du 0");}
        ProductCreatedEvent event = new ProductCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductCreatedEvent event){
        this.id = event.getId();
        this.name=event.getName();
        this.description=event.getDescription();
        this.price=event.getPrice();
        this.category=event.getCategory();
        this.quantity=event.getQuantity();
    }
}
