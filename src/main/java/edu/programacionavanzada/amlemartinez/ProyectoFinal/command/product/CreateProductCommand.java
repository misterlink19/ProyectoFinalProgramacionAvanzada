package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Product;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.CreateProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;

import java.math.BigDecimal;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateProductCommand extends Command<CreateProductResponse> {

    private String name;
    private String description;
    private long availableQuantity;
    private BigDecimal price;

    public Product toProduct() {
        return Product.builder()
                .name(name)
                .description(description)
                .availableQuantity(availableQuantity)
                .price(price)
                .build();
    }
}
