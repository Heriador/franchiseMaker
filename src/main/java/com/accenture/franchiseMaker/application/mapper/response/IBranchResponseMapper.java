package com.accenture.franchiseMaker.application.mapper.response;

import com.accenture.franchiseMaker.application.dto.response.BranchResponse;
import com.accenture.franchiseMaker.domain.model.Branch;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IBranchResponseMapper {

    @Mapping(target = "franchiseId", source = "franchise.id")
    BranchResponse toBranchResponse(Branch branch);
}
