package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class GetAddressCommand extends Command<GetAddressResponse> {

    private Long id;
}
