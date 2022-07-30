package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressCommand extends Command<UpdateAddressResponse> {

    private Long id;
    private String name;
    private String description;
}