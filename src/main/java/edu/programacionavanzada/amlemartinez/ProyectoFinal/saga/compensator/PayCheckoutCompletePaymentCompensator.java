package edu.programacionavanzada.amlemartinez.ProyectoFinal.saga.compensator;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaStepCompensator;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class PayCheckoutCompletePaymentCompensator implements SagaStepCompensator<PayCheckoutResponse> {

    private final OrderRepository orderRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        Order order = sagaPayload.getProperty(PayCheckoutCommand.ORDER);
        orderRepository.delete(order);
    }
}
