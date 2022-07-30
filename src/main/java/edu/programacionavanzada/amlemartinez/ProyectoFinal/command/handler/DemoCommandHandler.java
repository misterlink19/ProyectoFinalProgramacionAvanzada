package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.handler;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.DemoCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.DemoResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.SagaOrchestrator;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.saga.model.Saga;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.saga.SagaFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
@CommandEvent(command = DemoCommand.class)
@Slf4j
public class DemoCommandHandler implements CommandHandler<DemoResponse, DemoCommand> {

    private final SagaOrchestrator sagaOrchestrator;

    @Value("${pattern.saga.timeout}")
    private int timeout;

    @Override
    public DemoResponse handle(DemoCommand command) {
        Saga<DemoResponse> saga = SagaFactory.createDemoSaga(UUID.randomUUID(), command);
        return sagaOrchestrator.orchestrate(saga, timeout);
    }
}
