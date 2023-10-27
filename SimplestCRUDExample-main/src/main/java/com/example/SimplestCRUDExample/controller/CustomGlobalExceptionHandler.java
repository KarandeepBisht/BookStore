package com.example.SimplestCRUDExample.controller;

import com.example.SimplestCRUDExample.Error.*;
import com.example.SimplestCRUDExample.Exception.CustomServiceException;
import com.example.SimplestCRUDExample.Exception.CustomStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomGlobalExceptionHandler  {
    // Let Spring handle the exception, we just override the status code
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(RecordNotFoundException e) {
        CustomErrorResponse error = new CustomErrorResponse(CustomStatus.NOT_FOUND_CODE,e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.OK.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CustomServiceException.class)
    public ResponseEntity<CustomErrorResponse> handleCustomServiceException(CustomServiceException e) {
        CustomErrorResponse error = new CustomErrorResponse(CustomStatus.BAD_REQUEST_CODE,e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<CustomErrorResponse> handleGenericNullPointerException(NullPointerException e) {
        CustomErrorResponse error = new CustomErrorResponse("402",e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.PARTIAL_CONTENT.value()));
        return new ResponseEntity<>(error, HttpStatus.PARTIAL_CONTENT);
    }
    @ExceptionHandler(value = RequestInputMissing.class)
    public ResponseEntity<CustomErrorResponse> handleGenericNotFoundException(RequestInputMissing e) {
        CustomErrorResponse error = new CustomErrorResponse(CustomStatus.REQUEST_INPUT_NOT_PRESENT_CODE,e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RecordAlreadyExistsException.class)
    public ResponseEntity<CustomErrorResponse> RecordAlreadyExistsException(RecordAlreadyExistsException e) {
        CustomErrorResponse error = new CustomErrorResponse(CustomStatus.ALREADY_EXISTS_CODE,e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.CONFLICT.value()));
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(value = BadRequest.class)
    public ResponseEntity<CustomErrorResponse> BadRequest(BadRequest e) {
        CustomErrorResponse error = new CustomErrorResponse(CustomStatus.REQUEST_REJECTED_OR_BAD_REQUEST_CODE,e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity<CustomErrorResponse> RuntimeException(RuntimeException e) {
        CustomErrorResponse error = new CustomErrorResponse(CustomStatus.REQUEST_REJECTED_OR_BAD_REQUEST_CODE,e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = DatabaseOperationError.class)
    public ResponseEntity<CustomErrorResponse> BadRequest(DatabaseOperationError e) {
        CustomErrorResponse error = new CustomErrorResponse("715",e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.INTERNAL_SERVER_ERROR.value()));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ResponseEntity<CustomErrorResponse> exception(Exception e) {
        CustomErrorResponse error = new CustomErrorResponse(CustomStatus.BAD_REQUEST_CODE,e.getMessage());
        error.setTimestamp(LocalDateTime.now().toString());
        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
