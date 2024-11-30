package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.application.dto.request.UpdateBranchDto;
import com.accenture.franchiseMaker.application.dto.response.BranchResponse;
import jakarta.validation.Valid;

public interface IBranchHandler {
    void createBranch(CreateBranchDto createBranchDto);

    BranchResponse updateBranch(Long branchId, @Valid UpdateBranchDto updateBranchDto);
}
