package com.accenture.franchiseMaker.application.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UpdateBranchDto {

    @NotNull(message = "Name is required")
    @Size(min = 3, max = 90, message = "Name must be between 3 and 90 characters")
    private String name;
}
