package com.example.SimplestCRUDExample.Error;

public class BadRequest extends RuntimeException{
    public BadRequest(String id) {
        super(id);
    }
}

