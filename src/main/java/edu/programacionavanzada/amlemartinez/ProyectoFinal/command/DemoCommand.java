package edu.programacionavanzada.amlemartinez.ProyectoFinal.command;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.Command;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DemoCommand extends Command<DemoResponse> {

    private boolean explote;
}