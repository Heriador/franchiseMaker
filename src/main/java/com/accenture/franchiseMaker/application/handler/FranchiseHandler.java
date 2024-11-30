package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateFranchiseDto;
import com.accenture.franchiseMaker.application.dto.response.FranchiseProductsMoreStockResponse;
import com.accenture.franchiseMaker.application.mapper.request.IFranchiseRequestMapper;
import com.accenture.franchiseMaker.application.mapper.response.IFranchiseResponseMapper;
import com.accenture.franchiseMaker.domain.api.IFranchiseServicePort;
import com.accenture.franchiseMaker.domain.model.Franchise;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseHandler implements IFranchiseHandler{

    private final IFranchiseServicePort franchiseServicePort;
    private final IFranchiseRequestMapper franchiseRequestMapper;
    private final IFranchiseResponseMapper franchiseResponseMapper;

    @Override
    public void createFranchise(CreateFranchiseDto createFranchiseDto) {
        franchiseServicePort.createFranchise(franchiseRequestMapper.toFranchise(createFranchiseDto));
    }

    @Override
    public FranchiseProductsMoreStockResponse getProductsWithMoreStockByFranchiseId(Long franchiseId) {
       Franchise franchise = franchiseServicePort.getProductsWithMoreStockByFranchiseId(franchiseId);

       return franchiseResponseMapper.toFranchiseProductsMoreStockResponse(franchise);
    }
}
