package com.accenture.franchiseMaker.infrastructure.driven.mysql.repository;

import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByName(String name);

    Boolean existsByNameAndBranchId(String name, Long branchId);
}
