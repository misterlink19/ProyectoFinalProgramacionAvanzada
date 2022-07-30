package edu.programacionavanzada.amlemartinez.ProyectoFinal.handler;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.address.UpdateAddressCommand;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.command.handler.address.UpdateAddressCommandHandler;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Address;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.AddressDTO;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.exceptions.AddressNoFoundException;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.AddressRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
class UpdateAddressCommandHandlerTest {

    @Mock
    private AddressRepository addressRepository;

    @BeforeEach
    void setup() {
    }

    @Test
    void updateAddressTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setName("Hello");
        addressMock.setDescription("");
        UpdateAddressCommand createAddressCommand = UpdateAddressCommand.builder()
                .id(1L)
                .description("OMG")
                .build();
        Mockito.when(addressRepository.findById(ArgumentMatchers.eq(1L))).thenReturn(Optional.of(addressMock));
        UpdateAddressCommandHandler updateAddressCommandHandler = new UpdateAddressCommandHandler(addressRepository);
        UpdateAddressResponse updateAddressResponse = updateAddressCommandHandler.handle(createAddressCommand);
        assertNotNull(updateAddressResponse);
        AddressDTO address = updateAddressResponse.getAddress();
        assertEquals(addressMock.getId(), address.getId());
        assertEquals(addressMock.getName(), address.getName());
        assertEquals(createAddressCommand.getDescription(), address.getDescription());
    }

    @Test
    void updateAddressNoFoundTest() {
        Address addressMock = Mockito.spy(Address.class);
        addressMock.setId(1L);
        addressMock.setName("Hello");
        addressMock.setDescription("");
        UpdateAddressCommand createAddressCommand = UpdateAddressCommand.builder()
                .id(2L)
                .description("OMG")
                .build();
        Mockito.when(addressRepository.findById(ArgumentMatchers.eq(1L))).thenReturn(Optional.of(addressMock));
        UpdateAddressCommandHandler updateAddressCommandHandler = new UpdateAddressCommandHandler(addressRepository);
        assertThrows(AddressNoFoundException.class, () -> {
            UpdateAddressResponse updateAddressResponse = updateAddressCommandHandler.handle(createAddressCommand);
            assertNotNull(updateAddressResponse);
        });
    }

}