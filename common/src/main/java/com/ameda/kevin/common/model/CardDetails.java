package com.ameda.kevin.common.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDetails {
    private String name;
    private String cardNumber;
    private Integer validUntilMonth;
    private Integer  validUntilYear;
    private Integer ccv;
}
