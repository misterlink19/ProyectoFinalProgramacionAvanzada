package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address;


import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteAddressCommand extends Command<DeleteAddressResponse> {

    private Long id;
}