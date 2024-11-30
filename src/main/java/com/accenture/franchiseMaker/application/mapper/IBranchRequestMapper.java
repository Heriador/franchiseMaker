package com.accenture.franchiseMaker.application.mapper;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.domain.model.Branch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBranchRequestMapper {

    Branch toBranch(CreateBranchDto createBranchDto);
}
