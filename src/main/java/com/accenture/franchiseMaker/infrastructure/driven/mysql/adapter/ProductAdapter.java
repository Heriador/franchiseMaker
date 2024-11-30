package com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter;

import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.domain.spi.IProductPersistencePort;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IProductEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class ProductAdapter implements IProductPersistencePort {

    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;

    @Override
    public void createProduct(Product product) {

        productRepository.save(productEntityMapper.toEntity(product));
    }

    @Override
    public Optional<Product> findProductByName(String name) {

        return productRepository.findByName(name).map(productEntityMapper::toProduct);
    }

    @Override
    public Boolean existsByNameAndBranchId(String name, Long branchId) {
        return productRepository.existsByNameAndBranchId(name, branchId);
    }
}
