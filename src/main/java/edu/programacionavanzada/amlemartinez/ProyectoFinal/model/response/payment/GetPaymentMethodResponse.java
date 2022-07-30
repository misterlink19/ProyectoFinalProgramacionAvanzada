package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.payment;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.PaymentMethodDTO;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetPaymentMethodResponse {

    private List<PaymentMethodDTO> paymentMethods;
}
