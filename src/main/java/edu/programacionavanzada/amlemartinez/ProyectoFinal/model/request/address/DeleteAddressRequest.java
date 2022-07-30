package edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.DeleteAddressCommand;
import lombok.*;

import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DeleteAddressRequest {

    @NotNull
    private Long id;

    public DeleteAddressCommand toCommand() {
        return DeleteAddressCommand.builder()
                .id(id)
                .build();
    }
}
