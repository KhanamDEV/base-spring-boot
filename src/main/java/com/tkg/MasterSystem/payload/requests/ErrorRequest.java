package com.tkg.MasterSystem.payload.requests;

public class ErrorRequest<T> {
    public String message;

    public T data;

    public ErrorRequest(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
