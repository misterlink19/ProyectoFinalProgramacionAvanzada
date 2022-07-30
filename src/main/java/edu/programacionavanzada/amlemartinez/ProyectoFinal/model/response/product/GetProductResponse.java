package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetProductResponse {

    private List<ProductDTO> products;
}
