package edu.programacionavanzada.amlemartinez.ProyectoFinal.controllers;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.payment.CreatePaymentMethodRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.payment.DeletePaymentMethodRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.payment.UpdatePaymentMethodRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.payment.CreatePaymentMethodResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.payment.DeletePaymentMethodResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.payment.GetPaymentMethodResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.payment.UpdatePaymentMethodResponse;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.services.PaymentMethodService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/payment/methods")
public class PaymentMethodController {

    private final PaymentMethodService paymentMethodService;

    @GetMapping
    public ResponseEntity<GetPaymentMethodResponse> get() {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(paymentMethodService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetPaymentMethodResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(GetPaymentMethodResponse.builder()
                .paymentMethods(List.of(paymentMethodService.get(id)))
                .build());
    }

    @PostMapping
    public ResponseEntity<CreatePaymentMethodResponse> create(@RequestBody CreatePaymentMethodRequest createPaymentMethodRequest) {
        return ResponseEntity.ok(CreatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.create(createPaymentMethodRequest))
                .build());
    }

    @PutMapping
    public ResponseEntity<UpdatePaymentMethodResponse> update(@RequestBody UpdatePaymentMethodRequest updatePaymentMethodRequest) {
        return ResponseEntity.ok(UpdatePaymentMethodResponse.builder()
                .paymentMethod(paymentMethodService.update(updatePaymentMethodRequest))
                .build());
    }

    @DeleteMapping
    public ResponseEntity<DeletePaymentMethodResponse> delete(@RequestBody DeletePaymentMethodRequest deleteEmployeeRequest) {
        paymentMethodService.delete(deleteEmployeeRequest);
        return ResponseEntity.ok(DeletePaymentMethodResponse.builder().build());
    }
}
