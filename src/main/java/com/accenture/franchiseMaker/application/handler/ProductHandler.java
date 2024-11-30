package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.application.mapper.IProductRequestMapper;
import com.accenture.franchiseMaker.domain.api.IProductServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductHandler implements IProductHandler{

    private final IProductServicePort productServicePort;
    private final IProductRequestMapper productRequestMapper;

    @Override
    public void createProduct(CreateProductDto createProduct) {

        productServicePort.createProduct(productRequestMapper.toProduct(createProduct));
    }
}
