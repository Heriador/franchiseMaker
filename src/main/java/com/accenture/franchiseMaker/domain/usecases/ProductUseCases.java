package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IProductServicePort;
import com.accenture.franchiseMaker.domain.exceptions.ProductAlreadyExistsException;
import com.accenture.franchiseMaker.domain.exceptions.ProductNotFoundException;
import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.domain.spi.IProductPersistencePort;

public class ProductUseCases implements IProductServicePort {

    private final IProductPersistencePort productPersistencePort;

    public ProductUseCases(IProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public Product createProduct(Product product) {

        if(Boolean.TRUE.equals(productPersistencePort.existsByNameAndBranchId(product.getName(), product.getBranch().getId()))) {
            throw new ProductAlreadyExistsException("Product already exists");
        }

        return productPersistencePort.createProduct(product);

    }

    @Override
    public void deleteProduct(Long productId) {

        if(Boolean.FALSE.equals(productPersistencePort.existsById(productId))) {
            throw new ProductNotFoundException("Product not found");
        }

        productPersistencePort.deleteProduct(productId);

    }
}
