package com.accenture.franchiseMaker.infrastructure.driving.restcontroller;

import com.accenture.franchiseMaker.application.dto.request.CreateFranchiseDto;
import com.accenture.franchiseMaker.application.handler.IFranchiseHandler;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/franchise")
@RequiredArgsConstructor
@Tag(name = "Franchise Controller", description = "Franchise Controller")
public class FranchiseRestController {

    private final IFranchiseHandler franchiseHandler;

    @PostMapping
    public ResponseEntity<Void> createFranchise(@RequestBody CreateFranchiseDto createFranchiseDto){

        franchiseHandler.createFranchise(createFranchiseDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
