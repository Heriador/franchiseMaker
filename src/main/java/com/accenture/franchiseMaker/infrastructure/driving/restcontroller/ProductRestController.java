package com.accenture.franchiseMaker.infrastructure.driving.restcontroller;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.application.dto.request.UpdateProductDto;
import com.accenture.franchiseMaker.application.dto.response.ProductResponse;
import com.accenture.franchiseMaker.application.handler.IProductHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Tag(name = "Product Controller", description = "Product Controller")
public class ProductRestController {

    private final IProductHandler productHandler;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@Valid @RequestBody CreateProductDto createProduct) {

        ProductResponse response = productHandler.createProduct(createProduct);
        response.setBranchId(createProduct.getBranchId());

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productId) {
        productHandler.deleteProduct(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long productId, @Valid @RequestBody UpdateProductDto updateProductDto) {
        ProductResponse response = productHandler.updateProduct(updateProductDto, productId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
