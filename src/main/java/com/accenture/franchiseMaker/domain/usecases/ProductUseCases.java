package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IProductServicePort;
import com.accenture.franchiseMaker.domain.exceptions.ProductAlreadyExistsException;
import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.domain.spi.IProductPersistencePort;

public class ProductUseCases implements IProductServicePort {

    private final IProductPersistencePort productPersistencePort;

    public ProductUseCases(IProductPersistencePort productPersistencePort) {
        this.productPersistencePort = productPersistencePort;
    }

    @Override
    public void createProduct(Product product) {

        if(productPersistencePort.findProductByName(product.getName()).isPresent()){
            throw new ProductAlreadyExistsException("Product already exists");
        }

        productPersistencePort.createProduct(product);

    }
}
