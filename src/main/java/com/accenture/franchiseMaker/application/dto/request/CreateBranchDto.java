package com.accenture.franchiseMaker.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateBranchDto {

    @NotBlank(message = "Name is required")
    @Size(max = 90, message = "Name must be less than 90 characters")
    private String name;

    @NotNull(message = "Franchise id is required")
    @Positive(message = "Franchise id must be positive")
    private Long franchiseId;
}
