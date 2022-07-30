package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Address;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressCommand extends Command<CreateAddressResponse> {

    private String name;
    private String description;

    public Address toAddress() {
        return Address.builder()
                .name(name)
                .description(description)
                .build();
    }
}