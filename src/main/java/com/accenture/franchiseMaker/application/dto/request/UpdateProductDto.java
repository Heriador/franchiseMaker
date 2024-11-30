package com.accenture.franchiseMaker.application.dto.request;

import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
@AllArgsConstructor
public class UpdateProductDto {

    @PositiveOrZero(message = "Stock must be greater or equal to 0")
    private Long stock;

    @Length(min = 3, max = 50, message = "Name must be at least 3 characters and at most 50 characters")
    private String name;
}
