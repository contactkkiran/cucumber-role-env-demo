package com.example.singledriver.util;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {
    private static final Dotenv DOTENV = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    public static String get(String key) {
        String v = System.getenv(key);
        if (v != null) return v;
        return DOTENV.get(key);
    }

    public static String get(String key, String defaultValue) {
        String v = get(key);
        return v != null ? v : defaultValue;
    }
}
