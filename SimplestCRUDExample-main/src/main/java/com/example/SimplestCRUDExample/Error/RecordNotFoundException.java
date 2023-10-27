package com.example.SimplestCRUDExample.Error;

public class RecordNotFoundException extends RuntimeException{
    public RecordNotFoundException(String id) {
        super(id);
    }
}
