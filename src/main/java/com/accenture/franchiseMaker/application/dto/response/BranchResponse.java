package com.accenture.franchiseMaker.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class BranchResponse {

    private Long id;
    private String name;
    private Long franchiseId;
    private List<ProductResponse> products;
}
