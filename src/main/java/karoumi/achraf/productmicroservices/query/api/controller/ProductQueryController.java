package karoumi.achraf.productmicroservices.query.api.controller;

import karoumi.achraf.productmicroservices.common.api.response.ProductQueryResponse;
import karoumi.achraf.productmicroservices.query.api.queries.GetProductsQuery;
import lombok.AllArgsConstructor;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductQueryController {
    private QueryGateway queryGateway;

    @GetMapping
    public List<ProductQueryResponse> get(){
        GetProductsQuery getAll = new GetProductsQuery();
        List<ProductQueryResponse> listProducts = queryGateway.query(getAll, ResponseTypes.multipleInstancesOf(ProductQueryResponse.class)).join();
        return listProducts;
    }
}
