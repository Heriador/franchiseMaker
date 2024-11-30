package com.accenture.franchiseMaker.domain.spi;

import com.accenture.franchiseMaker.domain.model.Branch;

public interface IBranchPersistencePort {

    void createBranch(Branch branch);
}
