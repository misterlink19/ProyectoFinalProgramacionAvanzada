package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class GetAllAddressCommand extends Command<GetAddressResponse> {

    private int pageSize;
    private int page;
    private String name;

}