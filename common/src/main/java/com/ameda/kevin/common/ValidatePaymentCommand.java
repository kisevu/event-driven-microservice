package com.ameda.kevin.common;

import com.ameda.kevin.common.model.CardDetails;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ValidatePaymentCommand {
    private String paymentId;
    private String orderId;
    private CardDetails cardDetails;
}
