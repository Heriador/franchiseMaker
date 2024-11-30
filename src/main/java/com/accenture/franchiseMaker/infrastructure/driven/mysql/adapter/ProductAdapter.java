package com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter;

import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.domain.spi.IProductPersistencePort;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.ProductEntity;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IProductEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Transactional
@RequiredArgsConstructor
public class ProductAdapter implements IProductPersistencePort {

    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;

    @Override
    public Product createProduct(Product product) {

        ProductEntity response = productRepository.save(productEntityMapper.toEntity(product));

        return productEntityMapper.toProduct(response);
    }

    @Override
    public Optional<Product> findProductByName(String name) {

        return productRepository.findByName(name).map(productEntityMapper::toProduct);
    }

    @Override
    public Optional<Product> findProductById(Long productId) {
        return productRepository.findById(productId).map(productEntityMapper::toProduct);
    }

    @Override
    public Boolean existsByNameAndBranchId(String name, Long branchId) {
        return productRepository.existsByNameAndBranchId(name, branchId);
    }

    @Override
    public Boolean existsById(Long productId) {
        return productRepository.existsById(productId);
    }

    @Override
    public void deleteProduct(Long productId) {

        productRepository.deleteById(productId);

    }

    @Override
    public Product updateProduct(Product product) {

        ProductEntity productEntity = productRepository.findById(product.getId()).orElseThrow();

        if(product.getName() != null){
            productEntity.setName(product.getName());
        }

        if(product.getStock() != null){
            productEntity.setStock(product.getStock());
        }

        ProductEntity response = productRepository.save(productEntity);

        return productEntityMapper.toProduct(response);
    }
}
