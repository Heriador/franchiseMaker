package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateFranchiseDto;

public interface IFranchiseHandler {

    void createFranchise(CreateFranchiseDto createFranchiseDto);
}
