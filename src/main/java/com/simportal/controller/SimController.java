package com.simportal.controller;

import com.simportal.dto.SimValidateRequest;
import com.simportal.model.Offer;
import com.simportal.service.SimService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/sim")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")   // allow Vercel frontend
public class SimController {

    private final SimService simService;

    @PostMapping("/validate")
    public ResponseEntity<?> validate(@Valid @RequestBody SimValidateRequest req) {
        boolean valid = simService.isValidIccId(req.getIccId());
        return ResponseEntity.ok(Map.of("valid", valid));
    }

    @GetMapping("/offers/{iccId}")
    public ResponseEntity<List<Offer>> offers(@PathVariable String iccId) {
        if (!simService.isValidIccId(iccId)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(simService.getSpecialOffers(iccId));
    }
}