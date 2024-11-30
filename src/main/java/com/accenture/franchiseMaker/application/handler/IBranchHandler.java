package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;

public interface IBranchHandler {
    void createBranch(CreateBranchDto createBranchDto);
}
