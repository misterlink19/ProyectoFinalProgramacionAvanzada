package edu.programacionavanzada.amlemartinez.ProyectoFinal.saga.handler;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.checkout.PayCheckoutCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaPayload;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaStepHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


@RequiredArgsConstructor
@Component
public class PayCheckoutCompletePaymentHandler implements SagaStepHandler<PayCheckoutResponse> {

    @Override
    public void handle(SagaPayload<PayCheckoutResponse> sagaPayload) {
        String paymentIntent = sagaPayload.getProperty(PayCheckoutCommand.PAYMENT_INTENT);
        // Aquí terminaría mi payment intent con mastercard para que el balance se procese.
        if (LocalDateTime.now().getMinute() % 2 == 0) { // Condición de fallo dinámico puesto para ejemplo
            throw new RuntimeException("Error on process payment intent " + paymentIntent);
        }
    }
}
