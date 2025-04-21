package com.example.retryreplay.model;

public class Transaction {
    private String id;
    private String status;
    private String type;
    private String payload;

    public Transaction(String id, String status, String type, String payload) {
        this.id = id;
        this.status = status;
        this.type = type;
        this.payload = payload;
    }

    public String getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getType() {
        return type;
    }

    public String getPayload() {
        return payload;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}