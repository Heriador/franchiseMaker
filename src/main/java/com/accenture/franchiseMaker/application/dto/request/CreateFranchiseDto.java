package com.accenture.franchiseMaker.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateFranchiseDto {

    @NotBlank(message = "Name is required")
    @Size(max = 120, message = "Franchise name must be less than 120 characters")
    private String name;
}
