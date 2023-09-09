package com.tkg.MasterSystem.payload.responeses;

public class ApiResponse<T> {
    private int status;

    private T data;

    public ApiResponse(){};

    public ApiResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(T data) {
        this.data = data;
    }
}
