package com.accenture.franchiseMaker.infrastructure.configuration;

import com.accenture.franchiseMaker.domain.api.IProductServicePort;
import com.accenture.franchiseMaker.domain.spi.IProductPersistencePort;
import com.accenture.franchiseMaker.domain.usecases.ProductUseCases;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.adapter.ProductAdapter;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.mapper.IProductEntityMapper;
import com.accenture.franchiseMaker.infrastructure.driven.mysql.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IProductRepository productRepository;
    private final IProductEntityMapper productEntityMapper;

    @Bean
    public IProductPersistencePort productPersistencePort(){
        return new ProductAdapter(productRepository, productEntityMapper);
    }

    @Bean
    IProductServicePort productServicePort(IProductPersistencePort productPersistencePort){
        return new ProductUseCases(productPersistencePort);
    }

}
