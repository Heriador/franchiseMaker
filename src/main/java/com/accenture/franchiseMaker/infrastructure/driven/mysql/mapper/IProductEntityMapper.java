package com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper;

import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IProductEntityMapper {

     @Mapping(target = "id", ignore = true)
     ProductEntity toEntity(Product product);

     @Mapping(target = "branch.products", ignore = true)
     @Mapping(target = "branch.franchise.branches", ignore = true)
     Product toProduct(ProductEntity productEntity);

}
