package com.accenture.franchiseMaker.infrastructure.driven.mysql.repository;

import com.accenture.franchiseMaker.infrastructure.driven.mysql.entity.BranchEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBranchRepository extends JpaRepository<BranchEntity, Long> {


}
