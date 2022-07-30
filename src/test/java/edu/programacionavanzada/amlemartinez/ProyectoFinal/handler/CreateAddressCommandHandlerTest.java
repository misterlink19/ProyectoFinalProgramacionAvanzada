package edu.programacionavanzada.amlemartinez.ProyectoFinal.handler;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.CreateAddressCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.handler.address.CreateAddressCommandHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Address;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.AddressDTO;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class CreateAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void createAddressTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setName("Hello");
        addressMock.setDescription("");
        CreateAddressCommand createAddressCommand = CreateAddressCommand.builder()
                .name(addressMock.getName())
                .description(addressMock.getDescription())
                .build();
        Mockito.when(addressRepository.save(ArgumentMatchers.any())).thenReturn(addressMock);
        CreateAddressCommandHandler createAddressCommandHandler = new CreateAddressCommandHandler(addressRepository);
        CreateAddressResponse createAddressResponse = createAddressCommandHandler.handle(createAddressCommand);
        assertNotNull(createAddressResponse);
        AddressDTO address = createAddressResponse.getAddress();
        assertEquals(addressMock.getId(), address.getId());
        assertEquals(addressMock.getName(), address.getName());
        assertEquals(addressMock.getDescription(), address.getDescription());
    }
}