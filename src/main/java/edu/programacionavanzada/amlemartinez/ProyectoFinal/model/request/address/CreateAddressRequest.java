package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.CreateAddressCommand;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CreateAddressRequest {

    @Size(min = 4, max = 10)
    @NotBlank(message = "Campo nombre no puede estar vacío")
    private String name;

    @Size( max = 250)
    private String description;

    public CreateAddressCommand toCommand() {
        return CreateAddressCommand.builder()
                .name(name)
                .description(description)
                .build();
    }
}
