package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.payment;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeletePaymentMethodRequest {

    @NotNull
    @Positive
    private Long id;
}
