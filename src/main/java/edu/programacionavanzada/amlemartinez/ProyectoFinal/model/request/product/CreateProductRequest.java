package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product.CreateProductCommand;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateProductRequest {

    @Size(min = 4, max = 50)
    @NotBlank
    private String name;

    @Size(max = 250)
    private String description;

    @Positive
    @NotNull
    private long availableQuantity;

    @Positive
    @NotNull
    private BigDecimal price;

    public CreateProductCommand toCommand() {
        return CreateProductCommand.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }
}
