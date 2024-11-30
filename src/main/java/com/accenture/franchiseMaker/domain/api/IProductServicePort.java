package com.accenture.franchiseMaker.domain.api;

import com.accenture.franchiseMaker.domain.model.Product;

public interface IProductServicePort {

    Product createProduct(Product product);

    void deleteProduct(Long productId);

    Product updateProduct(Product product);
}
