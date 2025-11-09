package com.simportal.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class CustomerValidateRequest {
    @Email @NotBlank private String email;
    private LocalDate dob;
}