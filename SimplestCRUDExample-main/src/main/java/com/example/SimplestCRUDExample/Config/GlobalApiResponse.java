package com.example.SimplestCRUDExample.Config;


import java.io.Serializable;

public class GlobalApiResponse<T> implements Serializable {

    String responseCode;
    String responseMsg;
    ResponseStatus status;
    String timestamp;
    Object responseData;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Object getResponseData() {
        return responseData;
    }

    public void setResponseData(Object data) {
        this.responseData = data;
    }

    public void setResponse(String message, ResponseStatus status, T data) {
        this.responseMsg = message;
        this.status = status;
        this.responseData = data;
    }
}
