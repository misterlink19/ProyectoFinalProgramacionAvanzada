package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product.GetProductResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;


@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllProductCommand extends Command<GetProductResponse> {

}
