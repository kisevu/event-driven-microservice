package com.ameda.kevin.orders.saga.command.api.controller;

import com.ameda.kevin.orders.saga.command.api.command.CreateOrderCommand;
import com.ameda.kevin.orders.saga.command.api.model.OrderRestModel;
import lombok.RequiredArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderCommandController {
    private final CommandGateway commandGateway;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody OrderRestModel orderRestModel){
        String orderId = UUID.randomUUID().toString();
        CreateOrderCommand command = CreateOrderCommand.builder()
                .orderId(orderId)
                .addressId(orderRestModel.getAddressId())
                .productId(orderRestModel.getProductId())
                .quantity(orderRestModel.getQuantity())
                .orderStatus("CREATED")
                .build();
        commandGateway.sendAndWait(command);
        return new ResponseEntity<>("order placed...",HttpStatus.CREATED);
    }
}
