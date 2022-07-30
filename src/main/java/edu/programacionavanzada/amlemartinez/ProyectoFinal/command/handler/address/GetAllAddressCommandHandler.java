package edu.programacionavanzada.amlemartinez.ProyectoFinal.command.handler.address;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.GetAllAddressCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Address;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.AddressDTO;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandEvent;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.patterns.command.CommandHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.AddressRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@CommandEvent(command = GetAllAddressCommand.class)
@Slf4j
public class GetAllAddressCommandHandler implements CommandHandler<GetAddressResponse, GetAllAddressCommand> {

    private final AddressRepository addressRepository;

    @Override
    public GetAddressResponse handle(GetAllAddressCommand getAllAddressCommand) {
        log.debug("Get Addresses {}", getAllAddressCommand.toString());
        List<AddressDTO> addressDTOS = addressRepository.findAllByNameContainingIgnoreCase(
                        getAllAddressCommand.getName(),
                        PageRequest.of(getAllAddressCommand.getPage(), getAllAddressCommand.getPageSize()))
                .stream()
                .map(Address::toDTO)
                .collect(Collectors.toList());
        return GetAddressResponse.builder()
                .addresses(addressDTOS)
                .build();
    }
}
