package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.DeleteProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteProductCommand extends Command<DeleteProductResponse> {

    private Long id;
}
