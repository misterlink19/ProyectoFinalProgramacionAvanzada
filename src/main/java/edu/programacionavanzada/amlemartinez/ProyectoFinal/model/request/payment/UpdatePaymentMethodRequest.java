package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.payment;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdatePaymentMethodRequest {

    @NotNull
    @Positive
    private Long id;

    @Size( max = 250)
    private String description;

    @Positive
    @NotNull
    private long availableQuantity;

    @Positive
    @NotNull
    private BigDecimal price;

}
