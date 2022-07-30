package edu.programacionavanzada.amlemartinez.ProyectoFinal.services;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.GetAddressCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.GetAllAddressCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address.CreateAddressRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address.DeleteAddressRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address.UpdateAddressRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandBus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AddressService {

    private final CommandBus commandBus;

    public GetAddressResponse getAll(Integer pageSize, Integer page, String name) {
        return commandBus.sendCommand(GetAllAddressCommand.builder().pageSize(pageSize).page(page).name(name).build());
    }

    public GetAddressResponse get(Long id) {
        return commandBus.sendCommand(GetAddressCommand.builder().id(id).build());
    }

    public CreateAddressResponse create(CreateAddressRequest createAddressRequest) {
        return commandBus.sendCommand(createAddressRequest.toCommand());
    }

    public UpdateAddressResponse update(UpdateAddressRequest updateAddressRequest) {
        return commandBus.sendCommand(updateAddressRequest.toCommand());
    }

    public DeleteAddressResponse delete(DeleteAddressRequest deleteAddressRequest) {
        return commandBus.sendCommand(deleteAddressRequest.toCommand());
    }
}
