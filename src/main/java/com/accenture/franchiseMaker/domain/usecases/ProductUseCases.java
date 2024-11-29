package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IProductServicePort;
import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.domain.spi.IProductPersistancePort;

public class ProductUseCases implements IProductServicePort {

    private IProductPersistancePort productPersistancePort;

    @Override
    public void createProduct(String name, Long stock) {

        Product product = new Product(name, stock);

        productPersistancePort.createProduct(product);

    }
}
