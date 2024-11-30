package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.application.dto.response.ProductResponse;

public interface IProductHandler {
    ProductResponse createProduct(CreateProductDto createProduct);

    Void deleteProduct(Long productId);
}
