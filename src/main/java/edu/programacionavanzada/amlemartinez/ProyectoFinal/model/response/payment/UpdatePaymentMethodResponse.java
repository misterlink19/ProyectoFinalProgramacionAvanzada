package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.payment;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.PaymentMethodDTO;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodResponse {

    private PaymentMethodDTO paymentMethod;
}
