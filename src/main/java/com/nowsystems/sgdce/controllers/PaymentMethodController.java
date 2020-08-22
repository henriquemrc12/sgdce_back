package com.nowsystems.sgdce.controllers;


import com.nowsystems.sgdce.dto.UserModelDTO;
import com.nowsystems.sgdce.models.PaymentMethodModel;
import com.nowsystems.sgdce.models.UserModel;
import com.nowsystems.sgdce.servicies.PaymentMethodService;
import com.nowsystems.sgdce.servicies.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/paymentMethod")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PaymentMethodModel dto) {
        PaymentMethodModel r = paymentMethodService.create(dto);
        return ResponseEntity.ok(r);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody @Valid PaymentMethodModel dto) {
        PaymentMethodModel r = paymentMethodService.create(dto);
        return ResponseEntity.ok(r);
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<PaymentMethodModel> r = paymentMethodService.findAll();
        return ResponseEntity.ok(r);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        PaymentMethodModel r = paymentMethodService.findById(id);
        return ResponseEntity.ok(r);
    }

}
