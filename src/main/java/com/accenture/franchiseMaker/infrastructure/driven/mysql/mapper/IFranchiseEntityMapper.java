package com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper;

import com.accenture.franchiseMaker.domain.model.Franchise;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.FranchiseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IBranchEntityMapper.class})
public interface IFranchiseEntityMapper {

    @Mapping(target = "id", ignore = true)
    FranchiseEntity toEntity(Franchise franchise);

    Franchise toFranchise(FranchiseEntity franchiseEntity);

}
