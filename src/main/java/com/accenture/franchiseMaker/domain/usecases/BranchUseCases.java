package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import com.accenture.franchiseMaker.domain.model.Branch;
import com.accenture.franchiseMaker.domain.spi.IBranchPersistencePort;

public class BranchUseCases implements IBranchServicePort {

    private final IBranchPersistencePort branchPersistencePort;

    public BranchUseCases(IBranchPersistencePort branchPersistencePort) {
        this.branchPersistencePort = branchPersistencePort;
    }

    @Override
    public void createBranch(Branch branch) {

        branchPersistencePort.createBranch(branch);

    }
}
