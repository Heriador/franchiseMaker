package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import com.accenture.franchiseMaker.domain.api.IFranchiseServicePort;
import com.accenture.franchiseMaker.domain.exceptions.BranchAlreadyExistsException;
import com.accenture.franchiseMaker.domain.exceptions.BranchNotFoundException;
import com.accenture.franchiseMaker.domain.model.Branch;
import com.accenture.franchiseMaker.domain.spi.IBranchPersistencePort;

public class BranchUseCases implements IBranchServicePort {

    private final IBranchPersistencePort branchPersistencePort;
    private final IFranchiseServicePort franchiseServicePort;

    public BranchUseCases(IBranchPersistencePort branchPersistencePort, IFranchiseServicePort franchiseServicePort) {
        this.branchPersistencePort = branchPersistencePort;
        this.franchiseServicePort = franchiseServicePort;
    }

    @Override
    public void createBranch(String name, Long franchiseId) {

        Branch branch = new Branch();

        if(Boolean.TRUE.equals(branchPersistencePort.existsByNameAndFranchiseId(name, franchiseId))) {
            throw new BranchAlreadyExistsException("Branch already exists");
        }

        branch.setName(name);
        branch.setFranchise(franchiseServicePort.getFranchiseById(franchiseId));

        branchPersistencePort.createBranch(branch);

    }

    @Override
    public Branch getBranchById(Long id) {
        return branchPersistencePort.getBranchById(id)
                .orElseThrow(() -> new BranchNotFoundException("Branch not found"));
    }
}
