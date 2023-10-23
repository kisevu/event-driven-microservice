package com.ameda.kevin.orders.saga.command.api.command;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Data
@Builder
public class CreateOrderCommand {
    @TargetAggregateIdentifier
    private String orderId;
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
    private String orderStatus;
}
