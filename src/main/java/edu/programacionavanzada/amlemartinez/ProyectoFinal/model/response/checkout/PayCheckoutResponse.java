package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.OrderDTO;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PayCheckoutResponse {

    private OrderDTO orderDTO;
}
