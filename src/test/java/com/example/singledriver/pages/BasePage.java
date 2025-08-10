package com.example.singledriver.pages;

import com.example.singledriver.util.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    protected WebDriver driver;
    public BasePage() {
        this.driver = Driver.get();
        PageFactory.initElements(driver, this);
    }
    public String getTitle() { return driver.getTitle(); }
    public String getCurrentUrl() { return driver.getCurrentUrl(); }
}
