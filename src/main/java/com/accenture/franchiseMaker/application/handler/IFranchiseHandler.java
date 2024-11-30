package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateFranchiseDto;
import com.accenture.franchiseMaker.application.dto.response.FranchiseProductsMoreStockResponse;
import com.accenture.franchiseMaker.application.dto.response.FranchiseResponse;
import jakarta.validation.Valid;

public interface IFranchiseHandler {

    void createFranchise(CreateFranchiseDto createFranchiseDto);

    FranchiseProductsMoreStockResponse getProductsWithMoreStockByFranchiseId(Long franchiseId);

    FranchiseResponse updateFranchise(Long franchiseId, @Valid CreateFranchiseDto createFranchiseDto);
}
