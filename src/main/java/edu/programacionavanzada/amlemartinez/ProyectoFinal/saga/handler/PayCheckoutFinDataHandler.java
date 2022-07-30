package edu.programacionavanzada.amlemartinez.ProyectoFinal.saga.handler;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.exceptions.CheckoutNoFoundException;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.CheckoutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@RequiredArgsConstructor
@Component
public class PayCheckoutFinDataHandler implements SagaStepHandler<PayCheckoutResponse> {

    private final CheckoutRepository checkoutRepository;

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        PayCheckoutCommand command = sagaPayload.getProperty(PayCheckoutCommand.COMMAND);
        Checkout checkout = checkoutRepository.findById(command.getId()).orElseThrow(() -> new CheckoutNoFoundException(command.getId()));

        sagaPayload.addProperty(PayCheckoutCommand.CHECKOUT, checkout);
    }
}
