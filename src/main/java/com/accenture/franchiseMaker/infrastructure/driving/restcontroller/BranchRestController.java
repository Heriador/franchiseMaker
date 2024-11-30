package com.accenture.franchiseMaker.infrastructure.driving.restcontroller;

import com.accenture.franchiseMaker.application.dto.request.CreateBranchDto;
import com.accenture.franchiseMaker.application.dto.request.UpdateBranchDto;
import com.accenture.franchiseMaker.application.dto.response.BranchResponse;
import com.accenture.franchiseMaker.application.handler.IBranchHandler;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PatchMapping("/{branchId}")
    public ResponseEntity<BranchResponse> updateBranch(@PathVariable Long branchId, @Valid @RequestBody UpdateBranchDto updateBranchDto) {
        BranchResponse response = branchHandler.updateBranch(branchId, updateBranchDto);

        return ResponseEntity.ok(response);
    }

}
