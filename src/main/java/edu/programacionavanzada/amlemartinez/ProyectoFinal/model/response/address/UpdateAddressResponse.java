package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.AddressDTO;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressResponse {

    private AddressDTO address;
}
