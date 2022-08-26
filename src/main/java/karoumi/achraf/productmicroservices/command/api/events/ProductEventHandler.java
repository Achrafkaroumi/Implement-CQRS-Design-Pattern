package karoumi.achraf.productmicroservices.command.api.events;

import karoumi.achraf.productmicroservices.entity.Product;
import karoumi.achraf.productmicroservices.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProductEventHandler {
    private ProductRepository productRepository;

    @EventHandler
    public void on(ProductCreatedEvent event){
        Product product = new Product();
        BeanUtils.copyProperties(event,product);
        productRepository.save(product);
    }
}
