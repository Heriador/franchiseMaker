package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.application.dto.request.UpdateBranchDto;
import com.accenture.franchiseMaker.application.dto.response.BranchResponse;
import com.accenture.franchiseMaker.application.mapper.response.IBranchResponseMapper;
import com.accenture.franchiseMaker.domain.api.IBranchServicePort;
import com.accenture.franchiseMaker.domain.model.Branch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BranchHandler implements IBranchHandler{

    private final IBranchServicePort branchServicePort;
    private final IBranchResponseMapper branchResponseMapper;

    @Override
    public void createBranch(CreateBranchDto createBranchDto) {
        branchServicePort.createBranch(createBranchDto.getName(), createBranchDto.getFranchiseId());
    }

    @Override
    public BranchResponse updateBranch(Long branchId, UpdateBranchDto updateBranchDto) {

        Branch branch = new Branch();
        branch.setName(updateBranchDto.getName());
        branch.setId(branchId);

        return branchResponseMapper.toBranchResponse(branchServicePort.updateBranch(branch));
    }
}
