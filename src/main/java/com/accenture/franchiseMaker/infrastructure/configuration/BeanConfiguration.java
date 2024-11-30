package com.accenture.franchiseMaker.infrastructure.configuration;

import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import com.accenture.franchiseMaker.domain.api.IFranchiseServicePort;
import com.accenture.franchiseMaker.domain.api.IProductServicePort;
import com.accenture.franchiseMaker.domain.spi.IBranchPersistencePort;
import com.accenture.franchiseMaker.domain.spi.IFranchisePersistencePort;
import com.accenture.franchiseMaker.domain.spi.IProductPersistencePort;
import com.accenture.franchiseMaker.domain.usecases.BranchUseCases;
import com.accenture.franchiseMaker.domain.usecases.FranchiseUseCases;
import com.accenture.franchiseMaker.domain.usecases.ProductUseCases;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter.BranchAdapter;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter.FranchiseAdapter;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter.ProductAdapter;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IBranchEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IFranchiseEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IProductEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IBranchRepository;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IFranchiseRepository;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;
    private final IBranchRepository branchRepository;
    private final IBranchEntityMapper branchEntityMapper;
    private final IFranchiseRepository franchiseRepository;
    private final IFranchiseEntityMapper franchiseEntityMapper;

    @Bean
    public IProductPersistencePort productPersistencePort(){
        return new ProductAdapter(productRepository, productEntityMapper);
    }

    @Bean
    public IProductServicePort productServicePort(IProductPersistencePort productPersistencePort){
        return new ProductUseCases(productPersistencePort());
    }

    @Bean
    public IBranchPersistencePort branchPersistencePort(){
        return new BranchAdapter(branchRepository, branchEntityMapper);
    }

    @Bean
    public IBranchServicePort branchServicePort(IBranchPersistencePort branchPersistencePort){
        return new BranchUseCases(branchPersistencePort());
    }

    @Bean
    public IFranchisePersistencePort franchisePersistencePort(){
        return new FranchiseAdapter(franchiseRepository, franchiseEntityMapper);
    }

    @Bean
    public IFranchiseServicePort franchiseServicePort(IFranchisePersistencePort franchisePersistencePort){
        return new FranchiseUseCases(franchisePersistencePort());
    }
}
