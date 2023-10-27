package com.example.SimplestCRUDExample.Error;

public class DatabaseOperationError extends RuntimeException {

    public DatabaseOperationError(String id) {
        super(id);
    }

}

