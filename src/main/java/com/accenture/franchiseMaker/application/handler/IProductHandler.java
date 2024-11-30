package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.application.dto.request.UpdateProductDto;
import com.accenture.franchiseMaker.application.dto.response.ProductResponse;
import jakarta.validation.Valid;

public interface IProductHandler {
    ProductResponse createProduct(CreateProductDto createProduct);

    void deleteProduct(Long productId);

    ProductResponse updateProduct(@Valid UpdateProductDto updateProductDto, Long productId);
}
