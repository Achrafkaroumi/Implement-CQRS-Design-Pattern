package karoumi.achraf.productmicroservices.command.api.controller;

import karoumi.achraf.productmicroservices.command.api.commands.CreateProductCommand;
import karoumi.achraf.productmicroservices.common.api.request.ProductCommandRequest;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/product")
@AllArgsConstructor
public class ProductCommandController {
    private CommandGateway commandGateway;

    @PostMapping("/create")
    public String add(@RequestBody ProductCommandRequest request) {
        CreateProductCommand command = CreateProductCommand.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .price(request.getPrice())
                .category(request.getCategory())
                .description(request.getDescription())
                .quantity(request.getQuantity())
                .build();
        String commandSend = commandGateway.sendAndWait(command);
        return commandSend;
    }
}
