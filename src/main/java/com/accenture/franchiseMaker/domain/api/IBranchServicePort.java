package com.accenture.franchiseMaker.domain.api;

import com.accenture.franchiseMaker.domain.model.Branch;

public interface IBranchServicePort {

    Void createBranch(Branch branch);

    Branch getBranchById(Long id);

    Branch updateBranch(Branch branch);
}
