package com.simportal.controller;

import com.simportal.dto.CustomerRegisterRequest;
import com.simportal.dto.CustomerValidateRequest;
import com.simportal.model.Customer;
import com.simportal.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class CustomerController {

    private final CustomerService service;

    @PostMapping("/validate")
    public ResponseEntity<Map<String, Boolean>> validate(@Valid @RequestBody CustomerValidateRequest req) {
        boolean ok = service.validateEmailAndDob(req.getEmail(), req.getDob());
        return ResponseEntity.ok(Map.of("valid", ok));
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> register(@Valid @RequestBody CustomerRegisterRequest req) {
        Customer saved = service.register(req);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Customer> get(@PathVariable String email) {
        return service.findByEmail(email)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}