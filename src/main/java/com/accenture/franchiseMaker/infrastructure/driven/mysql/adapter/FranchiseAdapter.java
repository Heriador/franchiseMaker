package com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter;

import com.accenture.franchiseMaker.domain.model.Franchise;
import com.accenture.franchiseMaker.domain.spi.IFranchisePersistencePort;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IFranchiseEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IFranchiseRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class FranchiseAdapter implements IFranchisePersistencePort {

    private final IFranchiseRepository franchiseRepository;
    private final IFranchiseEntityMapper franchiseEntityMapper;

    @Override
    public void createFranchise(Franchise franchise) {
        franchiseRepository.save(franchiseEntityMapper.toEntity(franchise));
    }

    @Override
    public Optional<Franchise> getFranchiseById(Long id) {

        return franchiseRepository.findById(id)
                .map(franchiseEntityMapper::toFranchise);
    }

    @Override
    public Boolean existsByName(String name) {
        return franchiseRepository.existsByName(name);
    }
}
