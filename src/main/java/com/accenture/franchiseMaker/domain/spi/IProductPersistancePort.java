package com.accenture.franchiseMaker.domain.spi;

import com.accenture.franchiseMaker.domain.model.Product;

public interface IProductPersistancePort {

    void createProduct(Product product);
}
