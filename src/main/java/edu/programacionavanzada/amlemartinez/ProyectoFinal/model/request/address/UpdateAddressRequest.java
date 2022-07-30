package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.UpdateAddressCommand;
import lombok.*;

import javax.validation.constraints.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UpdateAddressRequest {

    @NotNull
    @Positive
    private Long id;

    @Size(min = 4, max = 10)
    @NotBlank(message = "Campo nombre no puede estar vacío")
    private String name;

    @Size(max = 250)
    private String description;

    public UpdateAddressCommand toCommand() {
        return UpdateAddressCommand.builder()
                .id(id)
                .name(name)
                .description(description)
                .build();
    }

}
