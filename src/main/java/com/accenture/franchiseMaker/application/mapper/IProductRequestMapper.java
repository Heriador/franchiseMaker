package com.accenture.franchiseMaker.application.mapper;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.domain.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IProductRequestMapper {

    Product toProduct(CreateProductDto createProduct);

}
