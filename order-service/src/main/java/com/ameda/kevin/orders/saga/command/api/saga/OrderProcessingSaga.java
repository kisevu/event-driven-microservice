package com.ameda.kevin.orders.saga.command.api.saga;

import com.ameda.kevin.common.ValidatePaymentCommand;
import com.ameda.kevin.orders.saga.command.api.events.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.modelling.saga.SagaEventHandler;
import org.axonframework.modelling.saga.StartSaga;
import org.axonframework.spring.stereotype.Saga;

@Saga
@Slf4j
public class OrderProcessingSaga {
    //for starting saga
    @StartSaga
    @SagaEventHandler(associationProperty = "orderId")
    private void handle(OrderCreatedEvent event){
        log.info("OrderCreatedEvent in Saga for orderId:{}",event.getOrderId());
        ValidatePaymentCommand validatePaymentCommand =
                ValidatePaymentCommand.builder().build();

    }
}
