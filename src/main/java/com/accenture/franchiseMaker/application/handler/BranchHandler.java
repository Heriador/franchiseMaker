package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.application.dto.request.UpdateBranchDto;
import com.accenture.franchiseMaker.application.dto.response.BranchResponse;
import com.accenture.franchiseMaker.application.mapper.request.IBranchRequestMapper;
import com.accenture.franchiseMaker.application.mapper.response.IBranchResponseMapper;
import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import com.accenture.franchiseMaker.domain.model.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchHandler implements IBranchHandler{

    private final IBranchServicePort branchServicePort;
    private final IBranchRequestMapper branchRequestMapper;
    private final IBranchResponseMapper branchResponseMapper;

    @Override
    public void createBranch(CreateBranchDto createBranchDto) {
        branchServicePort.createBranch(branchRequestMapper.toBranch(createBranchDto));
    }

    @Override
    public BranchResponse updateBranch(Long branchId, UpdateBranchDto updateBranchDto) {

        Branch branch = branchRequestMapper.toBranch(updateBranchDto);
        branch.setId(branchId);

        return branchResponseMapper.toBranchResponse(branchServicePort.updateBranch(branch));
    }
}
