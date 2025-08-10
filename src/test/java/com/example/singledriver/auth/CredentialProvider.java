package com.example.singledriver.auth;

public interface CredentialProvider {
    Credentials forRole(Role role);
}
