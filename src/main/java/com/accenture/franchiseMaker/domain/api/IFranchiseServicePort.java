package com.accenture.franchiseMaker.domain.api;

import com.accenture.franchiseMaker.domain.model.Franchise;

public interface IFranchiseServicePort {

    void createFranchise(Franchise franchise);

    Franchise getFranchiseById(Long id);
}
