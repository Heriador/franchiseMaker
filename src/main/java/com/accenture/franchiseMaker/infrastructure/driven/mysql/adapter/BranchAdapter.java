package com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter;

import com.accenture.franchiseMaker.domain.model.Branch;
import com.accenture.franchiseMaker.domain.spi.IBranchPersistencePort;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IBranchEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IBranchRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class BranchAdapter implements IBranchPersistencePort {

    private final IBranchRepository branchRepository;
    private final IBranchEntityMapper branchEntityMapper;

    @Override
    public void createBranch(Branch branch) {

        branchRepository.save((branchEntityMapper.toEntity(branch)));
    }
}
