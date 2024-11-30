package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateFranchiseDto;
import com.accenture.franchiseMaker.application.dto.response.FranchiseProductsMoreStockResponse;

public interface IFranchiseHandler {

    void createFranchise(CreateFranchiseDto createFranchiseDto);

    FranchiseProductsMoreStockResponse getProductsWithMoreStockByFranchiseId(Long franchiseId);
}
