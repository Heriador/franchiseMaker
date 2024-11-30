package com.accenture.franchiseMaker.application.mapper;

import com.accenture.franchiseMaker.application.dto.request.CreateFranchiseDto;
import com.accenture.franchiseMaker.domain.model.Franchise;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IFranchiseRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "branches", ignore = true)
    Franchise toFranchise(CreateFranchiseDto createFranchiseDto);
}
