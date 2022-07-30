package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.checkout;


import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Checkout;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout.PayCheckoutResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.SagaPayLoadKey;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutCommand extends Command<PayCheckoutResponse> {

    public static final SagaPayLoadKey<UUID> ID = new SagaPayLoadKey<>("id", UUID.class);
    public static final SagaPayLoadKey<PayCheckoutCommand> COMMAND = new SagaPayLoadKey<>("command", PayCheckoutCommand.class);
    public static final SagaPayLoadKey<Checkout> CHECKOUT = new SagaPayLoadKey<>("checkout", Checkout.class);
    public static final SagaPayLoadKey<Order> ORDER = new SagaPayLoadKey<>("order", Order.class);
    public static final SagaPayLoadKey<String> PAYMENT_INTENT = new SagaPayLoadKey<>("payment_intent", String.class);

    private UUID id;
}
