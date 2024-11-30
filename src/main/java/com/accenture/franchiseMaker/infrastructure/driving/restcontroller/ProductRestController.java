package com.accenture.franchiseMaker.infrastructure.driving.restcontroller;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.application.handler.IProductHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Product Controller", description = "Product Controller")
public class ProductRestController {

    private final IProductHandler productHandler;

    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody CreateProductDto createProduct) {

        productHandler.createProduct(createProduct);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
