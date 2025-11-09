package com.simportal.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
public class CustomerRegisterRequest {
    @NotBlank private String firstName;
    @NotBlank private String lastName;
    @Email @NotBlank private String email;
    private LocalDate dateOfBirth;

    private String street;
    private String city;
    private String state;
    private String zipCode;
}