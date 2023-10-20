package com.ameda.kevin.products.command.api.controller;

import com.ameda.kevin.products.command.api.commands.CreateProductCommand;
import com.ameda.kevin.products.command.api.model.ProductModel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/products")
@Slf4j
@RequiredArgsConstructor
public class ProductCommandController {
    private final CommandGateway commandGateway;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadProduct(@RequestBody ProductModel productModel){
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .name(productModel.getName())
                .price(productModel.getPrice())
                .quantity(productModel.getQuantity())
                .build();
        //send above command to command gateway...
        String result = commandGateway.sendAndWait(createProductCommand);
        return  new ResponseEntity<>(
                result
                ,HttpStatus.CREATED);
    }
}
