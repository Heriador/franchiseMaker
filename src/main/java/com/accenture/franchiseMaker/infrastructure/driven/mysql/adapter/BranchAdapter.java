package com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter;

import com.accenture.franchiseMaker.domain.model.Branch;
import com.accenture.franchiseMaker.domain.spi.IBranchPersistencePort;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.BranchEntity;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IBranchEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IBranchRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class BranchAdapter implements IBranchPersistencePort {

    private final IBranchRepository branchRepository;
    private final IBranchEntityMapper branchEntityMapper;

    @Override
    public Void createBranch(Branch branch) {

        branchRepository.save((branchEntityMapper.toEntity(branch)));
        return null;
    }

    @Override
    public Optional<Branch> getBranchById(Long id) {
        return branchRepository.findById(id)
                .map(branchEntityMapper::toBranch);
    }


    @Override
    public Boolean existsByNameAndFranchiseId(String name, Long franchiseId) {
        return branchRepository.existsByNameAndFranchiseId(name, franchiseId);
    }

    @Override
    public Boolean existsById(Long id) {
        return branchRepository.existsById(id);
    }

    @Override
    public Branch updateBranch(Branch branch) {

        BranchEntity branchEntity = branchRepository.findById(branch.getId()).orElseThrow();

        if(branch.getName() != null){
            branchEntity.setName(branch.getName());
        }

        BranchEntity response = branchRepository.save(branchEntity);

        return branchEntityMapper.toBranch(response);
    }
}
