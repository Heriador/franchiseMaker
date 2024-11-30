package com.accenture.franchiseMaker.domain.spi;

import com.accenture.franchiseMaker.domain.model.Franchise;

public interface IFranchisePersistencePort {

    void createFranchise(Franchise franchise);
}
