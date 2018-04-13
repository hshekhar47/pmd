package org.hshekhar.pmd.api.controller;

import org.hshekhar.pmd.api.model.PMDResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController<T>
{
    protected <T> ResponseEntity<PMDResponse<T>> createdResponse(T entity)
    {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new PMDResponse(entity));
    }

    protected <T> ResponseEntity<PMDResponse<T>> errorResponse(HttpStatus status, String errorMessage)
    {
        return ResponseEntity
                    .status(status)
                    .body(new PMDResponse<T>(errorMessage));
    }
}
