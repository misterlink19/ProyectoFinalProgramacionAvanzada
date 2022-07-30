package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.CheckoutDTO;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetCheckoutResponse {

    private List<CheckoutDTO> checkouts;
}
