package com.example.singledriver.pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    public boolean titleContains(String text) {
        String t = getTitle();
        return t != null && t.contains(text);
    }

    // Example "logout" action. Adjust locator for your app.
    public void logoutIfLoggedIn() {
        try {
            if (driver.findElements(By.cssSelector("#logout")).size() > 0) {
                driver.findElement(By.cssSelector("#logout")).click();
            }
        } catch (Exception ignored) {}
    }
}
