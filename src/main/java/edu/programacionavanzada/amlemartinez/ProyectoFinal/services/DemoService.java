package edu.programacionavanzada.amlemartinez.ProyectoFinal.services;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.DemoCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class DemoService {

    private final CommandBus commandBus;

    public DemoResponse get(boolean explote) {
        return commandBus.sendCommand(DemoCommand.builder().explote(explote).build());
    }
}
