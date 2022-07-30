package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.order;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.OrderDTO;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetOrderResponse {

    private List<OrderDTO> orders;
}
