package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.payment;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.PaymentMethod;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreatePaymentMethodRequest {

    @NotBlank
    @Size(min = 4, max = 50)
    private String name;

    @Size(max = 250)
    private String description;

    public PaymentMethod toPaymentMethod() {
        return PaymentMethod.builder()
                .name(name)
                .description(description)
                .build();
    }
}
