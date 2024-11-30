package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchHandler implements IBranchHandler{

    private final IBranchServicePort branchServicePort;

    @Override
    public void createBranch(CreateBranchDto createBranchDto) {
        branchServicePort.createBranch(createBranchDto.getName(), createBranchDto.getFranchiseId());
    }
}
