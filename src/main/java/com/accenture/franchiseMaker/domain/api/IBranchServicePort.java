package com.accenture.franchiseMaker.domain.api;

import com.accenture.franchiseMaker.domain.model.Branch;

public interface IBranchServicePort {

    void createBranch(String name, Long franchiseId);

    Branch getBranchById(Long id);

    Branch updateBranch(Branch branch);
}
