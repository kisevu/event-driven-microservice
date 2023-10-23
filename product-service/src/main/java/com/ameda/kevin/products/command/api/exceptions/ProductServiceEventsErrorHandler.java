package com.ameda.kevin.products.command.api.exceptions;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.eventhandling.EventMessageHandler;
import org.axonframework.eventhandling.ListenerInvocationErrorHandler;
import javax.annotation.Nonnull;
public class ProductServiceEventsErrorHandler implements ListenerInvocationErrorHandler {
    @Override
    public void onError(@Nonnull Exception e, @Nonnull EventMessage<?> eventMessage,
                        @Nonnull EventMessageHandler eventMessageHandler) throws Exception {
        throw e;
    }
}
