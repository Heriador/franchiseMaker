package com.accenture.franchiseMaker.domain.spi;

import com.accenture.franchiseMaker.domain.model.Branch;

import java.util.Optional;

public interface IBranchPersistencePort {

    Void createBranch(Branch branch);

    Optional<Branch> getBranchById(Long id);

    Boolean existsByNameAndFranchiseId(String name, Long franchiseId);

    Boolean existsById(Long id);

    Branch updateBranch(Branch branch);
}
