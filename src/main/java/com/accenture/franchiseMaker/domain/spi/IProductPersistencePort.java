package com.accenture.franchiseMaker.domain.spi;

import com.accenture.franchiseMaker.domain.model.Product;

import java.util.Optional;

public interface IProductPersistencePort {

    void createProduct(Product product);

    Optional<Product> findProductByName(String name);
}
