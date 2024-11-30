package com.accenture.franchiseMaker.domain.usecases;

import com.accenture.franchiseMaker.domain.api.IFranchiseServicePort;
import com.accenture.franchiseMaker.domain.exceptions.FranchiseAlreadyExistsException;
import com.accenture.franchiseMaker.domain.exceptions.FranchiseNotFoundException;
import com.accenture.franchiseMaker.domain.model.Franchise;
import com.accenture.franchiseMaker.domain.model.Product;
import com.accenture.franchiseMaker.domain.spi.IFranchisePersistencePort;

import java.util.Comparator;
import java.util.List;

public class FranchiseUseCases implements IFranchiseServicePort {

    private final IFranchisePersistencePort franchisePersistencePort;

    public FranchiseUseCases(IFranchisePersistencePort franchisePersistencePort) {
        this.franchisePersistencePort = franchisePersistencePort;
    }

    @Override
    public void createFranchise(Franchise franchise) {

        if(Boolean.TRUE.equals(franchisePersistencePort.existsByName(franchise.getName()))){
            throw new FranchiseAlreadyExistsException("Franchise already exists");
        }

        franchisePersistencePort.createFranchise(franchise);
    }

    @Override
    public Franchise getFranchiseById(Long id) {

        return franchisePersistencePort.getFranchiseById(id)
                .orElseThrow(() -> new FranchiseNotFoundException("Franchise not found"));
    }

    @Override
    public Franchise getProductsWithMoreStockByFranchiseId(Long franchiseId) {
        Franchise franchise = this.getFranchiseById(franchiseId);

        franchise.getBranches().forEach(branch -> branch.getProducts().stream()
                .max(Comparator.comparingLong(Product::getStock))
                .ifPresent(product -> branch.setProducts(List.of(product))));

        return franchise;
    }

    @Override
    public Franchise updateFranchise(Franchise franchise) {

        if(Boolean.FALSE.equals(franchisePersistencePort.existsById(franchise.getId()))){
            throw new FranchiseNotFoundException("Franchise not found");
        }

        return franchisePersistencePort.updateFranchise(franchise);
    }
}
