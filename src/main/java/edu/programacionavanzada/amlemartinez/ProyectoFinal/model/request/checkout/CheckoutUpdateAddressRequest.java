package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.checkout;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutUpdateAddressRequest {

    @NotNull
    private UUID id;


    @NotEmpty
    @Positive
    private Long address;
}
