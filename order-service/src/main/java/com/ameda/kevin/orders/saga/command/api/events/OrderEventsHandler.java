package com.ameda.kevin.orders.saga.command.api.events;

import com.ameda.kevin.orders.saga.command.api.data.Order;
import com.ameda.kevin.orders.saga.command.api.data.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventsHandler {
    private final OrderRepository orderRepository;
    @EventHandler
    public void on(OrderCreatedEvent event){
        Order order = Order.builder().build();
        BeanUtils.copyProperties(event,order);
        orderRepository.save(order);
    }
}
