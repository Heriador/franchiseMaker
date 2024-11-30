package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import com.accenture.franchiseMaker.domain.exceptions.BranchAlreadyExistsException;
import com.accenture.franchiseMaker.domain.exceptions.BranchNotFoundException;
import com.accenture.franchiseMaker.domain.model.Branch;
import com.accenture.franchiseMaker.domain.spi.IBranchPersistencePort;

public class BranchUseCases implements IBranchServicePort {

    private final IBranchPersistencePort branchPersistencePort;

    public BranchUseCases(IBranchPersistencePort branchPersistencePort) {
        this.branchPersistencePort = branchPersistencePort;
    }

    @Override
    public Void createBranch(Branch branch) {

        if(Boolean.TRUE.equals(branchPersistencePort.existsByNameAndFranchiseId(branch.getName(), branch.getFranchise().getId()))){
            throw new BranchAlreadyExistsException("Branch already exists");
        }

        branchPersistencePort.createBranch(branch);

        return null;
    }

    @Override
    public Branch getBranchById(Long id) {
        return branchPersistencePort.getBranchById(id)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found"));
    }

    @Override
    public Branch updateBranch(Branch branch) {

        if(Boolean.FALSE.equals(branchPersistencePort.existsById(branch.getId()))){
            throw new BranchNotFoundException("Branch not found");
        }

        return branchPersistencePort.updateBranch(branch);
    }
}
