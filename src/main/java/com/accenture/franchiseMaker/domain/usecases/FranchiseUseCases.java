package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IFranchiseServicePort;
import com.accenture.franchiseMaker.domain.model.Franchise;
import com.accenture.franchiseMaker.domain.spi.IFranchisePersistencePort;

public class FranchiseUseCases implements IFranchiseServicePort {

    private final IFranchisePersistencePort franchisePersistencePort;

    public FranchiseUseCases(IFranchisePersistencePort franchisePersistencePort) {
        this.franchisePersistencePort = franchisePersistencePort;
    }

    @Override
    public void createFranchise(Franchise franchise) {
        franchisePersistencePort.createFranchise(franchise);
    }
}
