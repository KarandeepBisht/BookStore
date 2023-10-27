package com.example.SimplestCRUDExample.Error;

public class RecordAlreadyExistsException extends RuntimeException{
    public RecordAlreadyExistsException(String id) {
        super(id);
    }
}
