package com.simportal.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SimValidateRequest {
    @NotBlank
    private String iccId;
}