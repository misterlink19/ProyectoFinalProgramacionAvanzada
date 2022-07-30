package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.handler.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.DeleteAddressCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@CommandEvent(command = DeleteAddressCommand.class)
@Slf4j
public class DeleteAddressCommandHandler implements CommandHandler<DeleteAddressResponse, DeleteAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public DeleteAddressResponse handle(DeleteAddressCommand deleteAddressCommand) {
        addressRepository.deleteById(deleteAddressCommand.getId());
        log.info("Address {} deleted", deleteAddressCommand.getId());
        return DeleteAddressResponse.builder()
                .build();
    }
}