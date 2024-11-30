package com.accenture.franchiseMaker.application.mapper.request;

import com.accenture.franchiseMaker.application.dto.request.CreateProductDto;
import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import com.accenture.franchiseMaker.domain.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { IBranchServicePort.class })
public interface IProductRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "branchId", target = "branch")
    Product toProduct(CreateProductDto createProduct);

}
