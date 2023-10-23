package com.ameda.kevin.products.command.api.events;

import com.ameda.kevin.products.command.api.data.entity.Product;
import com.ameda.kevin.products.command.api.data.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@ProcessingGroup("product")
public class ProductEventsHandler {
    private final ProductRepository productRepository;
    @EventHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        Product product = Product.builder().build();
        BeanUtils.copyProperties(productCreatedEvent,product);
        productRepository.save(product);
    }
//of the axon framework...
    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
