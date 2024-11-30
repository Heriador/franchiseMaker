package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.application.mapper.request.IBranchRequestMapper;
import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchHandler implements IBranchHandler{

    private final IBranchServicePort branchServicePort;
    private final IBranchRequestMapper branchRequestMapper;

    @Override
    public void createBranch(CreateBranchDto createBranchDto) {
        branchServicePort.createBranch(branchRequestMapper.toBranch(createBranchDto));
    }
}
