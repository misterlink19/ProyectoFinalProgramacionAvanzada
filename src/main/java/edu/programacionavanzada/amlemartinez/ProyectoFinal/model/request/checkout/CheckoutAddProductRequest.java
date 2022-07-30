package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.checkout;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CheckoutAddProductRequest {

    @NotNull
    private UUID id;

    @Positive
    @NotNull
    private Long product;

    @Positive
    @NotNull
    private Long quantity;
}
