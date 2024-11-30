package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;

public interface IProductHandler {
    void createProduct(CreateProductDto createProduct);
}
