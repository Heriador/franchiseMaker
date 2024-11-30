package com.accenture.franchiseMaker.application.handler;

import com.accenture.franchiseMaker.application.dto.request.CreateFranchiseDto;
import com.accenture.franchiseMaker.application.mapper.request.IFranchiseRequestMapper;
import com.accenture.franchiseMaker.domain.api.IFranchiseServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FranchiseHandler implements IFranchiseHandler{

    private final IFranchiseServicePort franchiseServicePort;
    private final IFranchiseRequestMapper franchiseRequestMapper;

    @Override
    public void createFranchise(CreateFranchiseDto createFranchiseDto) {
        franchiseServicePort.createFranchise(franchiseRequestMapper.toFranchise(createFranchiseDto));
    }
}
