package com.accenture.franchiseMaker.application.dto.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CreateProductDto {

    @NotBlank(message = "Name is required")
    @Size(max = 50, message = "Name must be less than 50 characters")
    private String name;

    @NotNull(message = "Stock is required")
    @PositiveOrZero(message = "Stock must be greater or equal to 0")
    private Long stock;

    @NotNull(message = "BranchId is required")
    @Positive(message = "BranchId must be greater than 0")
    private Long branchId;
}
