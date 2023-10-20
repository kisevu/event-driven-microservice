package com.ameda.kevin.products.command.api.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductModel {
    private String name;
    private BigDecimal price;
    private Integer quantity;
}
