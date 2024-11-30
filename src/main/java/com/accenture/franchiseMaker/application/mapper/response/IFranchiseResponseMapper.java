package com.accenture.franchiseMaker.application.mapper.response;

import com.accenture.franchiseMaker.application.dto.response.FranchiseProductsMoreStockResponse;
import com.accenture.franchiseMaker.application.dto.response.FranchiseResponse;
import com.accenture.franchiseMaker.application.dto.response.ProductResponse;
import com.accenture.franchiseMaker.domain.model.Franchise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring", uses = { IBranchResponseMapper.class })
public interface IFranchiseResponseMapper {

    FranchiseResponse toFranchiseResponse(Franchise franchise);

    @Mapping(target = "products", source = "franchise",qualifiedByName = "mapProducts")
    FranchiseProductsMoreStockResponse toFranchiseProductsMoreStockResponse(Franchise franchise);

    @Named("mapProducts")
    default List<ProductResponse> mapProducts(Franchise franchise){

        return franchise.getBranches().stream()
                .flatMap(branch -> branch.getProducts().stream())
                .map(product -> {
                    ProductResponse productResponse = new ProductResponse();
                    productResponse.setId(product.getId());
                    productResponse.setName(product.getName());
                    productResponse.setStock(product.getStock());
                    productResponse.setBranchId(product.getBranch().getId());
                    return productResponse;
                }).toList();

    }

}
