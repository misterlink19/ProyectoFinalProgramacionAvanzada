package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product.UpdateProductCommand;
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
public class UpdateProductRequest {

    @NotNull
    @Positive
    private Long id;

    @Size(max = 250)
    private String description;

    @NotNull
    @Positive
    private long availableQuantity;

    @Positive
    @NotNull
    private BigDecimal price;

    public UpdateProductCommand toCommand() {
        return UpdateProductCommand.builder()
                .id(id)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }

}
