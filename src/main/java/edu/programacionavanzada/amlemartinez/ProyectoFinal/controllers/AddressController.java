package edu.programacionavanzada.amlemartinez.ProyectoFinal.controllers;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address.CreateAddressRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address.DeleteAddressRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.address.UpdateAddressRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.CreateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.DeleteAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.GetAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.address.UpdateAddressResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.services.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/addresses")
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public ResponseEntity<GetAddressResponse> getAll(@RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                                     @RequestParam(required = false, defaultValue = "0") Integer page,
                                                     @RequestParam(required = false, defaultValue = "") String name) {
        return ResponseEntity.ok(addressService.getAll(pageSize, page, name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetAddressResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(addressService.get(id));
    }

    @PostMapping
    public ResponseEntity<CreateAddressResponse> create(@Valid @RequestBody CreateAddressRequest createAddressRequest) {
        return ResponseEntity.ok(addressService.create(createAddressRequest));
    }

    @PutMapping
    public ResponseEntity<UpdateAddressResponse> update(@Valid @RequestBody UpdateAddressRequest updateAddressRequest) {
        return ResponseEntity.ok(addressService.update(updateAddressRequest));
    }

    @DeleteMapping
    public ResponseEntity<DeleteAddressResponse> delete(@Valid @RequestBody DeleteAddressRequest deleteEmployeeRequest) {
        return ResponseEntity.ok(addressService.delete(deleteEmployeeRequest));
    }
}
