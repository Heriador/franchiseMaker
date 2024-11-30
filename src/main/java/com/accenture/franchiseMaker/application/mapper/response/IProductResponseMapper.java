package com.accenture.franchiseMaker.application.mapper.response;

import com.accenture.franchiseMaker.application.dto.response.ProductResponse;
import com.accenture.franchiseMaker.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IProductResponseMapper {

    @Mapping(source = "branch.id", target = "branchId")
    ProductResponse toProductResponse(Product product);
}
