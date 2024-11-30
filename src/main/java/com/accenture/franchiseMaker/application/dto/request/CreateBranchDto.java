package com.accenture.franchiseMaker.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
}
