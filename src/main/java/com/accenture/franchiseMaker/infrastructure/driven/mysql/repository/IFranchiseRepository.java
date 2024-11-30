package com.accenture.franchiseMaker.infrastructure.driven.mysql.repository;

import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.FranchiseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFranchiseRepository extends JpaRepository<FranchiseEntity, Long> {

}
