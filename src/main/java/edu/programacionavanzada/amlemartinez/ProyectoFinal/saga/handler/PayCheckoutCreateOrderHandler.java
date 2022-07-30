package edu.programacionavanzada.amlemartinez.ProyectoFinal.saga.handler;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.LogEvent;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.services.LogEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;


@RequiredArgsConstructor
@Component
public class PayCheckoutCreateOrderHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final LogEventService logEventService;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        UUID id = sagaPayload.getProperty(PayCheckoutCommand.ID);
        PayCheckoutCommand command = sagaPayload.getProperty(PayCheckoutCommand.COMMAND);
        Checkout checkout = sagaPayload.getProperty(PayCheckoutCommand.CHECKOUT);
        Order order = checkout.toOrder();
        logEventService.save(LogEvent.builder()
                .classOwner(getClass().toString())
                .processId(id)
                .process("Create Order")
                .parameterMap(Map.of("command", command))
                .build());
        sagaPayload.addProperty(PayCheckoutCommand.ORDER, order);
        // Solicito a mastercard la reserva del balance con mi payment intent
        sagaPayload.addProperty(PayCheckoutCommand.PAYMENT_INTENT, UUID.randomUUID().toString());
    }
}
