package com.accenture.franchiseMaker.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateFranchiseDto {

    @NotNull(message = "Name is required")
    @Size(min = 3, max = 120, message = "Name must be between 3 and 120 characters")
    private String name;
}
