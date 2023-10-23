package com.ameda.kevin.orders.saga.command.api.aggregate;

import com.ameda.kevin.orders.saga.command.api.command.CreateOrderCommand;
import com.ameda.kevin.orders.saga.command.api.events.OrderCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class OrderAggregate {
    @AggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;
    public OrderAggregate(){
    }
    @CommandHandler
    public OrderAggregate(CreateOrderCommand command){
        //validate command...
        OrderCreatedEvent orderCreatedEvent = OrderCreatedEvent.builder().build();
        BeanUtils.copyProperties(command,orderCreatedEvent);
        //send data to the Axon server...
        AggregateLifecycle.apply(orderCreatedEvent);
    }
    @EventSourcingHandler
    public void on(OrderCreatedEvent event){
        //whatever events are there in the event object needs to be updated to our aggregate...
        this.orderStatus = event.getOrderStatus();
        this.userId = event.getUserId();
        this.orderId = event.getOrderId();
        this.quantity = event.getQuantity();
        this.productId = event.getProductId();
        this.addressId = event.getAddressId();
    }
}
