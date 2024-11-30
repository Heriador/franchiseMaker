package com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper;

import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IBranchEntityMapper.class})
public interface IProductEntityMapper {

     @Mapping(target = "id", ignore = true)
     ProductEntity toEntity(Product product);

     Product toProduct(ProductEntity productEntity);

}
