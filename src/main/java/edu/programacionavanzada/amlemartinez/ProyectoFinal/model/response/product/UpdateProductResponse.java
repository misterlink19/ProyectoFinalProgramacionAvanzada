package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.product;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.ProductDTO;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateProductResponse {

    private ProductDTO product;
}
