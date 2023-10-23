package com.ameda.kevin.orders.saga.command.api.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRestModel {
    private String productId;
    private String userId;
    private String addressId;
    private Integer quantity;
}
