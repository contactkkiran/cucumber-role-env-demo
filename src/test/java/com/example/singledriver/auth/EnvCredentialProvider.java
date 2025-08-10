package com.example.singledriver.auth;

import com.example.singledriver.util.Env;

public class EnvCredentialProvider implements CredentialProvider {
    @Override
    public Credentials forRole(Role role) {
        String prefix = role.envPrefix();
        String user = Env.get(prefix + "_USERNAME");
        String pass = Env.get(prefix + "_PASSWORD");
        if (user == null || pass == null) {
            throw new IllegalStateException("Missing credentials for role: " + role +
                " (need " + prefix + "_USERNAME and " + prefix + "_PASSWORD in env)");
        }
        return new Credentials(user, pass);
    }
}
