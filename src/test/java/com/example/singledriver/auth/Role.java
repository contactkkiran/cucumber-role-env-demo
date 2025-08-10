package com.example.singledriver.auth;

public enum Role {
    ADMIN, APPROVER, BUYER;
    public String envPrefix() { return name(); }
}
