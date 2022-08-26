package karoumi.achraf.productmicroservices.query.api.projection;

import karoumi.achraf.productmicroservices.common.api.response.ProductQueryResponse;
import karoumi.achraf.productmicroservices.entity.Product;
import karoumi.achraf.productmicroservices.query.api.queries.GetProductsQuery;
import karoumi.achraf.productmicroservices.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class ProductProjection {
    private ProductRepository productRepository;

    @QueryHandler
    public List<ProductQueryResponse> handle(GetProductsQuery getProducts){
        List<Product> products = productRepository.findAll();
        List<ProductQueryResponse> productQueryResponses = products.stream()
                .map(product -> ProductQueryResponse.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .description(product.getDescription())
                        .price(product.getPrice())
                        .category(product.getCategory())
                        .quantity(product.getQuantity())
                        .build())
                .collect(Collectors.toList());
        return productQueryResponses;
    }
}
