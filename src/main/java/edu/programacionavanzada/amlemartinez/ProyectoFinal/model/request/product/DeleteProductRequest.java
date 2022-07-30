package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product.DeleteProductCommand;
import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductRequest {

    @Positive
    @NotNull
    private Long id;

    public DeleteProductCommand toCommand() {
        return DeleteProductCommand.builder()
                .id(id)
                .build();
    }
}
