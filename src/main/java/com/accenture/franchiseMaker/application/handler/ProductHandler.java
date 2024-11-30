package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.application.dto.response.ProductResponse;
import com.accenture.franchiseMaker.application.mapper.request.IProductRequestMapper;
import com.accenture.franchiseMaker.application.mapper.response.IProductResponseMapper;
import com.accenture.franchiseMaker.domain.api.IProductServicePort;
import com.accenture.franchiseMaker.domain.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductHandler implements IProductHandler{

    private final IProductServicePort productServicePort;
    private final IProductRequestMapper productRequestMapper;
    private final IProductResponseMapper productResponseMapper;

    @Override
    public ProductResponse createProduct(CreateProductDto createProduct) {

        Product response =  productServicePort.createProduct(productRequestMapper.toProduct(createProduct));

        return productResponseMapper.toProductResponse(response);
    }

    @Override
    public Void deleteProduct(Long productId) {

        productServicePort.deleteProduct(productId);

        return null;
    }
}
