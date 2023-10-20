package com.ameda.kevin.products.command.api.aggregate;

import com.ameda.kevin.products.command.api.commands.CreateProductCommand;
import com.ameda.kevin.products.command.api.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String productId;
    private String name;
    private BigDecimal price;
    private Integer quantity;
    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand){
        ProductCreatedEvent productCreatedEvent = ProductCreatedEvent.builder().build();
        //we can use the builder pattern to create else we can do as below...
        BeanUtils.copyProperties(createProductCommand,productCreatedEvent);
        //publish events...
        AggregateLifecycle.apply(productCreatedEvent);
    }
    public ProductAggregate(){}
    @EventSourcingHandler
    public void on(ProductCreatedEvent productCreatedEvent){
        this.quantity = productCreatedEvent.getQuantity();
        this.name = productCreatedEvent.getName();
        this.productId = productCreatedEvent.getProductId();
        this.price = productCreatedEvent.getPrice();
    }
}
