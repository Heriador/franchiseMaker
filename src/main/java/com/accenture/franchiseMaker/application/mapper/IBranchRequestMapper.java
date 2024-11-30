package com.accenture.franchiseMaker.application.mapper;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.domain.api.IFranchiseServicePort;
import com.accenture.franchiseMaker.domain.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { IFranchiseServicePort.class })
public interface IBranchRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(source = "franchiseId", target = "franchise")
    Branch toBranch(CreateBranchDto createBranchDto);
}
