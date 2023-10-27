package com.example.SimplestCRUDExample.Exception;

public interface CustomStatus {
    String NOT_FOUND_CODE ="404";
    String NOT_FOUND_MSG ="Record not found";
    String  BAD_REQUEST_CODE	="400";
    String REQUEST_INPUT_NOT_PRESENT_CODE = "900";
    String ALREADY_EXISTS_CODE ="409";
    String ALREADY_EXISTS_MSG ="Record already exists";
    String  REQUEST_REJECTED_OR_BAD_REQUEST_CODE	="653";
}
