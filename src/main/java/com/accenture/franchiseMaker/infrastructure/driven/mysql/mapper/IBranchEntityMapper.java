package com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper;

import com.accenture.franchiseMaker.domain.model.Branch;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.BranchEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {IProductEntityMapper.class})
public interface IBranchEntityMapper {

    @Mapping(target = "id", ignore = true)
    BranchEntity toEntity(Branch branch);

    @Mapping(target = "franchise", ignore = true)
    Branch toBranch(BranchEntity branchEntity);
}
