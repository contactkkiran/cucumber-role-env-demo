package com.example.singledriver.steps;

import com.example.singledriver.auth.*;
import com.example.singledriver.pages.HomePage;
import com.example.singledriver.pages.LoginPage;
import com.example.singledriver.util.Env;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class RoleSteps {
    private final CredentialProvider provider = new EnvCredentialProvider();
    private final LoginPage loginPage = new LoginPage();
    private final HomePage homePage = new HomePage();
    private String baseUrl;

    @Given("I load env configuration")
    public void i_load_env_configuration() {
        baseUrl = Env.get("DOMAIN_URL", "https://example.org");
    }

    @When("I switch to role {word}")
    public void i_switch_to_role(String roleName) {
        homePage.logoutIfLoggedIn();
        Role role = Role.valueOf(roleName.toUpperCase());
        Credentials c = provider.forRole(role);
        loginPage.open(baseUrl);
        loginPage.login(c.username(), c.password());
    }

    @Then("the title should contain {string}")
    public void the_title_should_contain(String expected) {
        Assertions.assertTrue(homePage.titleContains(expected),
                "Expected title to contain: " + expected + " but was: " + homePage.getTitle());
    }
}
