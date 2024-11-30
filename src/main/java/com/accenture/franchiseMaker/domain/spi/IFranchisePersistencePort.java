package com.accenture.franchiseMaker.domain.spi;

import com.accenture.franchiseMaker.domain.model.Franchise;

import java.util.Optional;

public interface IFranchisePersistencePort {

    void createFranchise(Franchise franchise);

    Optional<Franchise> getFranchiseById(Long id);

    Boolean existsByName(String name);

    Boolean existsById(Long id);

    Franchise updateFranchise(Franchise franchise);
}
