package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.CheckoutDTO;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutAddProductResponse {

    private CheckoutDTO checkout;
}
