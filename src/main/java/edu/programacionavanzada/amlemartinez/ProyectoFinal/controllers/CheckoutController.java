package edu.programacionavanzada.amlemartinez.ProyectoFinal.controllers;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.checkout.CheckoutAddProductRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.checkout.CheckoutUpdateAddressRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.checkout.CheckoutUpdatePaymentMethodRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.request.checkout.PayCheckoutRequest;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.response.checkout.*;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.services.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/checkout")
public class CheckoutController {

    private final CheckoutService checkoutService;

    @GetMapping
    public ResponseEntity<GetCheckoutResponse> get() {
        return ResponseEntity.ok(GetCheckoutResponse.builder()
                .checkouts(checkoutService.getAll())
                .build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetCheckoutResponse> get(@PathVariable UUID id) {
        return ResponseEntity.ok(GetCheckoutResponse.builder()
                .checkouts(List.of(checkoutService.get(id)))
                .build());
    }

    @PostMapping("/update/address")
    public ResponseEntity<CheckoutUpdateAddressResponse> updateAddress(@Valid @RequestBody CheckoutUpdateAddressRequest checkoutUpdateAddressRequest) {
        return ResponseEntity.ok(CheckoutUpdateAddressResponse.builder()
                .checkout(checkoutService.updateAddress(checkoutUpdateAddressRequest))
                .build());
    }

    @PostMapping("/update/payment/method")
    public ResponseEntity<CheckoutUpdatePaymentMethodResponse> updatePaymentMethod(@Valid @RequestBody CheckoutUpdatePaymentMethodRequest checkoutUpdatePaymentMethodRequest) {
        return ResponseEntity.ok(CheckoutUpdatePaymentMethodResponse.builder()
                .checkout(checkoutService.updatePaymentMethod(checkoutUpdatePaymentMethodRequest))
                .build());
    }

    @PostMapping("/add/product")
    public ResponseEntity<CheckoutAddProductResponse> addProduct(@Valid @RequestBody CheckoutAddProductRequest checkoutAddProductRequest) {
        return ResponseEntity.ok(CheckoutAddProductResponse.builder()
                .checkout(checkoutService.addProducts(checkoutAddProductRequest))
                .build());
    }

    @PostMapping("/pay")
    public ResponseEntity<PayCheckoutResponse> pay(@Valid @RequestBody PayCheckoutRequest payCheckoutRequest) {
        return ResponseEntity.ok(checkoutService.pay(payCheckoutRequest));
    }
}
