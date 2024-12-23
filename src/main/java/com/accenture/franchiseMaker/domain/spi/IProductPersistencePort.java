package com.accenture.franchiseMaker.domain.spi;

import com.accenture.franchiseMaker.domain.model.Product;

import java.util.Optional;

public interface IProductPersistencePort {

    Product createProduct(Product product);

    Optional<Product> findProductByName(String name);

    Optional<Product> findProductById(Long productId);

    Boolean existsByNameAndBranchId(String name, Long branchId);

    Boolean existsById(Long productId);

    void deleteProduct(Long productId);

    Product updateProduct(Product product);
}
