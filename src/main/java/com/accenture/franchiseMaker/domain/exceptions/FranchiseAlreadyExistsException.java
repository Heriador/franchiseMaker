package com.accenture.franchiseMaker.domain.exceptions;

public class FranchiseAlreadyExistsException extends RuntimeException {
    public FranchiseAlreadyExistsException(String message) {
        super(message);
    }
}
