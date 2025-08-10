package com.example.singledriver.hooks;

import com.example.singledriver.util.Driver;
import com.example.singledriver.util.Env;
import io.cucumber.java.*;

public class SuiteHooks {

    @BeforeAll
    public static void globalSetup() {
        // Start one browser for the entire test suite
        Driver.get().get(Env.get("DOMAIN_URL", "https://example.org"));
    }

    @AfterAll
    public static void globalTeardown() {
        // Quit the single browser after all scenarios
        Driver.quit();
    }

    @Before
    public void beforeEach(Scenario s) {
        // Optional isolation: clear state while keeping the same browser
        Driver.get().manage().deleteAllCookies();
        Driver.get().navigate().to(Env.get("DOMAIN_URL", "https://example.org"));
    }
}
