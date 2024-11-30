package com.accenture.franchiseMaker.infrastructure.driving.restcontroller;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.application.handler.IBranchHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/branch")
@RequiredArgsConstructor
public class BranchRestController {

    private final IBranchHandler branchHandler;

    @PostMapping
    public ResponseEntity<Void> createBranch(@Valid @RequestBody CreateBranchDto createBranchDto) {
        branchHandler.createBranch(createBranchDto);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
