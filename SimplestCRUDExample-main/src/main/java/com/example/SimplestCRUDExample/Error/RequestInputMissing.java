package com.example.SimplestCRUDExample.Error;

public class RequestInputMissing  extends RuntimeException {

    public RequestInputMissing(String id) {
        super(id);
    }

}

